package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.playobjects.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.LEVEL_PATH;

class FromFileLevelTest {
    @Test
    void getLevelTest() {
        Level level = new FromFileLevel(LEVEL_PATH).getLevel();
        assertEquals(level.staticObstacles.size(), 15, "Wrong number of obstacles!");
        assertEquals(level.dynamicObjects.size(), 4, "Wrong number of tanks!");
    }
}