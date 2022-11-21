package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StaticObject;
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
        for (StaticObject state: getObstacles()) {
            level.addStaticObstacles(state);
        }
        for (DynamicObject dynamic: getPlayers()) {
            level.addDynamicObject(dynamic);
        }
        for (DynamicObject dynamic: getEnemies()) {
            level.addDynamicObject(dynamic);
        }
        return level;
    }
    private ArrayList<StaticObject> getObstacles() {
        ArrayList<StaticObject> obstacles = new ArrayList<>();
        int count = ThreadLocalRandom.current().nextInt(1, (int) (0.15* WINDOW_WIDTH * WINDOW_HEIGHT) + 1);
        while (obstacles.size() < count) {
            int x = ThreadLocalRandom.current().nextInt(1, WINDOW_WIDTH + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WINDOW_HEIGHT + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                obstacles.add(new StaticObject(newVar, TypeGameObjects.TREE));
                objects.add(newVar);
            }
        }
        return obstacles;
    }

    private ArrayList<DynamicObject> getPlayers() {
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

    private ArrayList<DynamicObject> getEnemies() {
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
