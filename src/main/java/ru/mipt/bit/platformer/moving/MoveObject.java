package ru.mipt.bit.platformer.moving;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

public interface MoveObject {
     GridPoint2 getNewCoordinates(Input input, GridPoint2 coordinates);
     float getNewRotation(Input input, float rotation);
}
