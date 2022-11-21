package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.GLOBAL_MOVEMENT_SPEED;

public class MovingAbility {

    private final float initialMovementSpeed;
    public GridPoint2 nextCoordinates;

    private float movementProgress = 1f;

    public MovingAbility(float initialMovementSpeed, GridPoint2 nextCoordinates, float movementProgress) {
        this.initialMovementSpeed = initialMovementSpeed;
        this.nextCoordinates = nextCoordinates;
        this.movementProgress = movementProgress;
    }

    public MovingAbility(GridPoint2 nextCoordinates) {
        this.initialMovementSpeed = GLOBAL_MOVEMENT_SPEED;
        this.nextCoordinates = new GridPoint2(nextCoordinates);
    }

    public MovingAbility(GridPoint2 nextCoordinates, float movementProgress) {
        this(nextCoordinates);
        this.movementProgress = movementProgress;
    }

    public MovingAbility(float initialMovementSpeed, GridPoint2 nextCoordinates) {
        this.initialMovementSpeed = initialMovementSpeed;
        this.nextCoordinates = nextCoordinates;
    }

    public float getInitialMovementSpeed() {
        return initialMovementSpeed;
    }

    public float getMovementProgress() {
        return movementProgress;
    }

    public void setMovementProgress(float movementProgress) {
        this.movementProgress = movementProgress;
    }
}
