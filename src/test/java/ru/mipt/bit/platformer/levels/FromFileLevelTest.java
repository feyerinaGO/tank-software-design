package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mipt.bit.platformer.game_data.Constant.LEVEL_PATH;

class FromFileLevelTest {
    private final FromFileLevel fromFileLevel = new FromFileLevel(LEVEL_PATH);

    @Test
    void getObstaclesCoordinatesTest() {
        var obstacles = fromFileLevel.getObstaclesCoordinates();
        assertEquals(obstacles.size(), 15, "Wrong number of obstacles!");

    }

    @Test
    void getPlayersCoordinatesTest() {
        var players = fromFileLevel.getPlayersCoordinates();
        assertEquals(players.size(), 1, "Wrong number of players!");
    }

    @Test
    void getEnemiesCoordinatesTest() {
        var enemies = fromFileLevel.getEnemiesCoordinates();
        assertEquals(enemies.size(), 0, "Wrong number of obstacles!");
    }
}