package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.GridPoint2;

import java.util.List;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public class DynamicObject {
    private static final float MOVEMENT_SPEED = 0.4f;
    public StateObject state;
    public GridPoint2 coordinates;

    public float movementProgress = 1f;

    public DynamicObject(GridPoint2 initialCoordinates, float rotation) {
        this.state = new StateObject(initialCoordinates, rotation);
        this.coordinates = new GridPoint2(this.state.initialCoordinates);
    }

    public void rotate(List<StateObject> staticObstacles) {
        if (!isEqual(movementProgress, 1f)) { return; }
        GridPoint2 coordinates = getNewCoordinates(new GridPoint2(state.initialCoordinates));
        state.rotation = getNewRotation(state.rotation);

        if (isNotObstacle(staticObstacles, coordinates)) {
            state.initialCoordinates.set(coordinates);
            movementProgress = 0f;
        }
    }

    private static GridPoint2 getNewCoordinates(GridPoint2 coordinates) {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            coordinates.y++;
        } else if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            coordinates.x--;
        } else if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            coordinates.y--;
        } else if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            coordinates.x++;
        }
        return coordinates;
    }

    private static float getNewRotation(float newRotation) {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            return 90f;
        }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            return -180f;
        }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            return -90f;
        }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            return 0f;
        }
        return newRotation;
    }

    private boolean isNotObstacle(List<StateObject> staticObstacles, GridPoint2 coordinates) {
        for (StateObject obstacle : staticObstacles) {
            if (obstacle.initialCoordinates.equals(coordinates)) {
                return false;
            }
        }
        return true;
    }


    public void calculatePlayerCoordinates(float deltaTime) {
        getMovementProgress(deltaTime);
        setNewCoordinates();
    }

    private void setNewCoordinates() {
        if (isEqual(movementProgress, 1f)) {
            // record that the player has reached his/her destination
            coordinates.set(state.initialCoordinates);
        }
    }

    private void getMovementProgress(float deltaTime) {
        movementProgress = continueProgress(movementProgress, deltaTime, MOVEMENT_SPEED);
    }
}
