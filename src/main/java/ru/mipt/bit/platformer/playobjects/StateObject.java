package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;

public class StateObject {
    public GridPoint2 initialCoordinates;
    public float rotation = 0f;

    public StateObject(GridPoint2 initialCoordinates, float rotation) {
        this(initialCoordinates);
        this.rotation = rotation;
    }
    public StateObject(GridPoint2 initialCoordinates) {
        this.initialCoordinates = new GridPoint2(initialCoordinates);
    }
}
