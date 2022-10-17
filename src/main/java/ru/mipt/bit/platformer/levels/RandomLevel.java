package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import static ru.mipt.bit.platformer.game_data.Constant.*;

public class RandomLevel implements CreateLevel{
    private final HashSet<GridPoint2> objects;

    public RandomLevel() {
        this.objects = new HashSet<>();
    }
    @Override
    public HashSet<GridPoint2> getObstaclesCoordinates() {
        HashSet<GridPoint2> obstacles = new HashSet<>();
        int count = ThreadLocalRandom.current().nextInt(1, (int) (0.15*WIN_WDT_TILES*WIN_HGT_TILES) + 1);
        while (obstacles.size() < count) {
            int x = ThreadLocalRandom.current().nextInt(1, WIN_WDT_TILES + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WIN_HGT_TILES + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                obstacles.add(newVar);
                objects.add(newVar);
            }
        }
        return obstacles;
    }

    @Override
    public HashSet<GridPoint2> getPlayersCoordinates() {
        HashSet<GridPoint2> players = new HashSet<>();
        while (players.size() < COUNT_PLAYERS) {
            int x = ThreadLocalRandom.current().nextInt(1, WIN_WDT_TILES + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WIN_HGT_TILES + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                players.add(newVar);
                objects.add(newVar);
            }
        }
        return players;
    }

    @Override
    public HashSet<GridPoint2> getEnemiesCoordinates() {
        HashSet<GridPoint2> enemies = new HashSet<>();
        while (enemies.size() < COUNT_ENEMIES) {
            int x = ThreadLocalRandom.current().nextInt(1, WIN_WDT_TILES + 1);
            int y = ThreadLocalRandom.current().nextInt(1, WIN_HGT_TILES + 1);
            GridPoint2 newVar = new GridPoint2(x, y);
            if (!objects.contains(newVar)) {
                enemies.add(newVar);
                objects.add(newVar);
            }
        }
        return enemies;
    }
}
