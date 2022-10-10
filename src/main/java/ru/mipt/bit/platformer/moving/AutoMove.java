package ru.mipt.bit.platformer.moving;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

public class AutoMove implements MoveObject {
    @Override
    public GridPoint2 getNewCoordinates(Input input, GridPoint2 coordinates) {
        return coordinates;
    }

    @Override
    public float getNewRotation(Input input, float rotation) {
        return rotation;
    }
}
