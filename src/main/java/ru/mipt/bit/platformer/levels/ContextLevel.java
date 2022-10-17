package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;
import java.util.HashSet;

import static ru.mipt.bit.platformer.game_data.Constant.LEVEL_PATH;

public class ContextLevel {
    public static final CreateLevel RANDOM = new RandomLevel();
    public static final CreateLevel FROM_FILE = new FromFileLevel(LEVEL_PATH);
    private static CreateLevel context;

    public static void setContext(CreateLevel context) {
        ContextLevel.context = context;
    }

    public static HashSet<GridPoint2> getObstaclesCoordinates() {
        return context.getObstaclesCoordinates();
    }

    public static HashSet<GridPoint2> getPlayersCoordinates() {
        return context.getPlayersCoordinates();
    }

    public static HashSet<GridPoint2> getEnemiesCoordinates() {
        return context.getEnemiesCoordinates();
    }
}
