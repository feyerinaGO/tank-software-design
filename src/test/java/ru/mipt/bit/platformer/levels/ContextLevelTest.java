package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.playobjects.Level;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.COUNT_ENEMIES;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.COUNT_PLAYERS;

class ContextLevelTest {

    @Test
    void getLevelRandomTest() {
        Level level = ContextLevel.getLevel(VariantLevel.RANDOM);
        boolean size = level.getStaticObstacles().size() > 0 && level.getStaticObstacles().size() < 13;
        assertTrue(size, "Wrong number of obstacles!");
        assertEquals(level.getDynamicObjects().size(), COUNT_ENEMIES + COUNT_PLAYERS, "Wrong number of obstacles!");
    }

    @Test
    void getLevelFromFileTest() {
        Level level = ContextLevel.getLevel(VariantLevel.FROM_FILE);
        assertEquals(level.getStaticObstacles().size(), 15, "Wrong number of obstacles!");
        assertEquals(level.getDynamicObjects().size(), 4, "Wrong number of tanks!");
    }
}