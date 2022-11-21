package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.COUNT_ENEMIES;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.COUNT_PLAYERS;

class RandomLevelTest {
    private final RandomLevel randomLevel = new RandomLevel();

    @Test
    void getLevelTest() {
        var level = randomLevel.getLevel();
        boolean size = level.getStaticObstacles().size() > 0 && level.getStaticObstacles().size() < 13;
        assertTrue(size, "Wrong number of obstacles!");
        assertEquals(level.getDynamicObjects().size(), COUNT_ENEMIES + COUNT_PLAYERS, "Wrong number of obstacles!");
    }
}