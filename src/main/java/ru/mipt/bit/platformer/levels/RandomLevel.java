package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StateObject;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.*;

public class RandomLevel implements CreateLevel{
    private final HashSet<GridPoint2> objects;

    public RandomLevel() {
        this.objects = new HashSet<>();
    }

    @Override
    public Level getLevel() {
        Level level = new Level();
        level.staticObstacles = getObstacles();
        level.dynamicObjects = getPlayers();
        level.dynamicObjects.addAll(getEnemies());
        return level;
    }
    public ArrayList<StateObject> getObstacles() {
        ArrayList<StateObject> obstacles = new ArrayList<>();
        int count = ThreadLocalRandom.current().nextInt(1, (int) (0.15* WINDOW_WIDTH * WINDOW_HEIGHT) + 1);
        while (obstacles.size() < count) {
            int x = ThreadLocalRandom.current().nextInt(1, WINDOW_WIDTH + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WINDOW_HEIGHT + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                obstacles.add(new StateObject(newVar, TypeGameObjects.TREE));
                objects.add(newVar);
            }
        }
        return obstacles;
    }

    public ArrayList<DynamicObject> getPlayers() {
        ArrayList<DynamicObject> players = new ArrayList<>();
        while (players.size() < COUNT_PLAYERS) {
            int x = ThreadLocalRandom.current().nextInt(1, WINDOW_WIDTH + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WINDOW_HEIGHT + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                players.add(new DynamicObject(newVar, TypeGameObjects.PLAYER));
                objects.add(newVar);
            }
        }
        return players;
    }

    public ArrayList<DynamicObject> getEnemies() {
        ArrayList<DynamicObject> enemies = new ArrayList<>();
        while (enemies.size() < COUNT_ENEMIES) {
            int x = ThreadLocalRandom.current().nextInt(1, WINDOW_WIDTH + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WINDOW_HEIGHT + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                enemies.add(new DynamicObject(newVar, TypeGameObjects.ENEMY));
                objects.add(newVar);
            }
        }
        return enemies;
    }

}
