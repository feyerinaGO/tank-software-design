package ru.mipt.bit.platformer.adapter;

import org.awesome.ai.AI;
import org.awesome.ai.Recommendation;
import org.awesome.ai.state.GameState;
import org.awesome.ai.state.immovable.Obstacle;
import org.awesome.ai.state.movable.Bot;
import org.awesome.ai.state.movable.Player;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.awesome.ai.Action.*;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_HEIGHT;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_WIDTH;

public class AdapterAIDirection extends Direction {
    private Level level;
    private GameState gameState;
    private AI algorithmAI;
    private List<Recommendation> recommendations;
    private static HashMap<Enum, Direction> directionsActions = new HashMap<>();
    private HashMap<DynamicObject, Direction> directionsForObjects = new HashMap<>();


    static {
        directionsActions.put(MoveNorth, Direction.UP);
        directionsActions.put(MoveEast, Direction.LEFT);
        directionsActions.put(MoveSouth, Direction.DOWN);
        directionsActions.put(MoveWest, Direction.RIGHT);
    }

    public AdapterAIDirection(Level level, AI algorithmAI) {
        this.level = level;
        this.algorithmAI = algorithmAI;
        gameState = convertLevelToGameState();
        recommendations = algorithmAI.recommend(gameState);
        getListDirections();
    }

    private GameState convertLevelToGameState() {
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        ArrayList<Bot> bots = new ArrayList<>();
        Player player;
        var playerBuilder = Player.builder();
        for (StateObject stateObject : level.staticObstacles) {
            obstacles.add(new Obstacle(stateObject.position.coordinates.x, stateObject.position.coordinates.y));
        }
        for (DynamicObject tank : level.dynamicObjects) {
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
        GameState newState = gameStateBuilder.build();
        return newState;
    }

    private void getListDirections() {
        for (Recommendation rcmd : recommendations) {
            DynamicObject source = (DynamicObject)rcmd.getActor().getSource();
            var action = rcmd.getAction();
            if (directionsActions.containsKey(action)) {
                directionsForObjects.put(source, directionsActions.get(action));
            }
        }
    }

    @Override
    public Direction getNextDirection(DynamicObject dynamicObject) {
        if (directionsForObjects.containsKey(dynamicObject)) {
            return directionsForObjects.get(dynamicObject);
        } else {
            return super.getNextDirection(dynamicObject);
        }
    }
}
