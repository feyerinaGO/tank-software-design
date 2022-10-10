package ru.mipt.bit.platformer.levels;

import com.badlogic.gdx.math.GridPoint2;

import java.util.HashSet;

public interface CreateLevel {
    HashSet<GridPoint2> getObstaclesCoordinates();
    HashSet<GridPoint2> getPlayersCoordinates();
    HashSet<GridPoint2> getEnemiesCoordinates();
}
