package ru.mipt.bit.platformer.moving;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

import static com.badlogic.gdx.Input.Keys.*;

public class PlayerMove implements MoveObject {
    @Override
    public GridPoint2 getNewCoordinates(Input input, GridPoint2 coordinates) {
        if (input.isKeyPressed(UP) || input.isKeyPressed(W)) {
            coordinates.y++;
        } else if (input.isKeyPressed(LEFT) || input.isKeyPressed(A)) {
            coordinates.x--;
        } else if (input.isKeyPressed(DOWN) || input.isKeyPressed(S)) {
            coordinates.y--;
        } else if (input.isKeyPressed(RIGHT) || input.isKeyPressed(D)) {
            coordinates.x++;
        }
        return coordinates;
    }

    @Override
    public float getNewRotation(Input input, float rotation) {
        if (input.isKeyPressed(UP) || input.isKeyPressed(W)) {
            return 90f;
        }
        if (input.isKeyPressed(LEFT) || input.isKeyPressed(A)) {
            return -180f;
        }
        if (input.isKeyPressed(DOWN) || input.isKeyPressed(S)) {
            return -90f;
        }
        if (input.isKeyPressed(RIGHT) || input.isKeyPressed(D)) {
            return 0f;
        }
        return rotation;
    }
}
