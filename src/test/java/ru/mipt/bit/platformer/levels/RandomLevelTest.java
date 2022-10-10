package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomLevelTest {
    private final RandomLevel randomLevel = new RandomLevel();

    @Test
    void getObstaclesCoordinatesTest() {
        var obstacles = randomLevel.getObstaclesCoordinates();
        boolean size = obstacles.size() > 0 && obstacles.size() < 13;
        assertTrue(size, "Wrong number of obstacles!");

    }

    @Test
    void getPlayersCoordinatesTest() {
        var players = randomLevel.getPlayersCoordinates();
        assertEquals(players.size(), 1, "Wrong number of players!");
    }

    @Test
    void getEnemiesCoordinatesTest() {
        var enemies = randomLevel.getEnemiesCoordinates();
        assertEquals(enemies.size(), 0, "Wrong number of obstacles!");
    }
}