package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

public class StateObject {
    public Position position;

    public StateObject(GridPoint2 initialCoordinates, float rotation, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, rotation, type);
    }
    public StateObject(GridPoint2 initialCoordinates, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, type);
    }
}
