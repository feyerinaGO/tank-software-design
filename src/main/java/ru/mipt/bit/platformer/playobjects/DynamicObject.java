package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.moving.ContextMove;

import java.util.List;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.game_data.Obstacles.obstaclesCoordinates;
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

    public void getNewPosition(List<StateObject> staticObstacles, Input input, boolean player) {
        if (!isEqual(movementProgress, 1f)) { return; }
        if (player) {
            ContextMove.setContext(ContextMove.PLAYER);
        } else {
            ContextMove.setContext(ContextMove.ENEMY);
        }
        GridPoint2 coordinates = ContextMove.getNewCoordinates(input, new GridPoint2(state.initialCoordinates));
        state.rotation = ContextMove.getNewRotation(input, state.rotation);

        if (isNotObstacle(staticObstacles, coordinates)) {
            state.initialCoordinates.set(coordinates);
            movementProgress = 0f;
        }
    }

    private boolean isNotObstacle(List<StateObject> staticObstacles, GridPoint2 coordinates) {
        for (StateObject obstacle : staticObstacles) {
            if (obstacle.initialCoordinates.equals(coordinates)) {
                return false;
            }
        }
        for (GridPoint2 obstacle : obstaclesCoordinates) {
            if (obstacle.equals(coordinates)) {
                return false;
            }
        }
        obstaclesCoordinates.add(coordinates);
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
