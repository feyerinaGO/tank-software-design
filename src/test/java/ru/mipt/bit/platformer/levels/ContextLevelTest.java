package ru.mipt.bit.platformer.levels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextLevelTest {

    @Test
    void setContextTest() {
        ContextLevel.setContext(ContextLevel.RANDOM);
        var obstacles = ContextLevel.getObstaclesCoordinates();
        boolean size = obstacles.size() > 0 && obstacles.size() < 13;
        assertTrue(size, "Wrong choice of random context!");
        ContextLevel.setContext(ContextLevel.FROM_FILE);
        obstacles = ContextLevel.getObstaclesCoordinates();
        assertEquals(obstacles.size(), 15, "Wrong choice of form file context!");
    }

    @Test
    void getObstaclesCoordinatesTest() {
        ContextLevel.setContext(ContextLevel.RANDOM);
        var obstacles = ContextLevel.getObstaclesCoordinates();
        boolean size = obstacles.size() > 0 && obstacles.size() < 13;
        assertTrue(size, "Wrong number of random obstacles!");
        ContextLevel.setContext(ContextLevel.FROM_FILE);
        obstacles = ContextLevel.getObstaclesCoordinates();
        assertEquals(obstacles.size(), 15, "Wrong number of from file obstacles!");
    }

    @Test
    void getPlayersCoordinatesTest() {
        ContextLevel.setContext(ContextLevel.RANDOM);
        var players = ContextLevel.getPlayersCoordinates();
        assertEquals(players.size(), 1, "Wrong number of random players!");
        ContextLevel.setContext(ContextLevel.FROM_FILE);
        players = ContextLevel.getPlayersCoordinates();
        assertEquals(players.size(), 1, "Wrong number of from file players!");
    }

    @Test
    void getEnemiesCoordinatesTest() {
        ContextLevel.setContext(ContextLevel.RANDOM);
        var enemies = ContextLevel.getEnemiesCoordinates();
        assertEquals(enemies.size(), 0, "Wrong number of random obstacles!");
        ContextLevel.setContext(ContextLevel.FROM_FILE);
        enemies = ContextLevel.getEnemiesCoordinates();
        assertEquals(enemies.size(), 0, "Wrong number of from file obstacles!");
    }
}