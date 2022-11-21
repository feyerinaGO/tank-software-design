package ru.mipt.bit.platformer.commands;

import org.awesome.ai.AI;
import org.awesome.ai.Recommendation;
import org.awesome.ai.state.GameState;
import org.awesome.ai.state.immovable.Obstacle;
import org.awesome.ai.state.movable.Bot;
import org.awesome.ai.state.movable.Player;
import org.awesome.ai.strategy.NotRecommendingAI;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StaticObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.awesome.ai.Action.*;
import static org.awesome.ai.Action.MoveWest;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_HEIGHT;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_WIDTH;

public class AIBasedCommandGenerator implements CommandGenerator {
    private final Level level;
    private static HashMap<Enum, Direction> directionsActions = new HashMap<>();


    static {
        directionsActions.put(MoveNorth, Direction.UP);
        directionsActions.put(MoveEast, Direction.LEFT);
        directionsActions.put(MoveSouth, Direction.DOWN);
        directionsActions.put(MoveWest, Direction.RIGHT);
    }

    public AIBasedCommandGenerator(Level level) {
        this.level = level;
    }


    private GameState convertLevelToGameState() {
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        ArrayList<Bot> bots = new ArrayList<>();
        Player player;
        var playerBuilder = Player.builder();
        for (StaticObject staticObject : level.getStaticObstacles()) {
            obstacles.add(new Obstacle(staticObject.position.coordinates.x, staticObject.position.coordinates.y));
        }
        for (DynamicObject tank : level.getDynamicObjects()) {
            if (tank.position.getType().equals(TypeGameObjects.ENEMY)) {
                var botBuilder = Bot.builder();
                botBuilder = botBuilder.source(tank);
                botBuilder = botBuilder.x(tank.position.coordinates.x);
                botBuilder = botBuilder.y(tank.position.coordinates.y);
                bots.add(botBuilder.build());
            } else if (tank.position.getType().equals(TypeGameObjects.PLAYER)) {
                playerBuilder = playerBuilder.source(tank);
                playerBuilder = playerBuilder.x(tank.position.coordinates.x);
                playerBuilder = playerBuilder.y(tank.position.coordinates.y);
            }
        }
        player = playerBuilder.build();
        var gameStateBuilder = GameState.builder();
        gameStateBuilder = gameStateBuilder.obstacles(obstacles);
        gameStateBuilder = gameStateBuilder.bots(bots);
        gameStateBuilder = gameStateBuilder.player(player);
        gameStateBuilder = gameStateBuilder.levelHeight(WINDOW_HEIGHT);
        gameStateBuilder = gameStateBuilder.levelWidth(WINDOW_WIDTH);
        return gameStateBuilder.build();
    }

    @Override
    public Collection<Command> generateCommands() {
        AI algorithmAI = new NotRecommendingAI();
        GameState gameState = convertLevelToGameState();
        List<Recommendation> recommendations = algorithmAI.recommend(gameState);
        List<Command> commandList = new ArrayList<>();
        for (Recommendation rcmd : recommendations) {
            DynamicObject source = (DynamicObject)rcmd.getActor().getSource();
            var action = rcmd.getAction();
            if (source.position.getType().equals(TypeGameObjects.ENEMY) && directionsActions.containsKey(action)) {
                commandList.add(new MoveCommand(directionsActions.get(action), source, level));
            } else if (action.equals(Shoot)) {
                commandList.add(new ShootCommand(source, level));
            }
        }
        return commandList;
    }
}
