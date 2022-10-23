package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.GLOBAL_MOVEMENT_SPEED;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public class MovingAbility {

    private float movementSpeed;
    public GridPoint2 nextCoordinates;
    public float movementProgress = 1f;

    public MovingAbility(float movementSpeed, GridPoint2 nextCoordinates, float movementProgress) {
        this.movementSpeed = movementSpeed;
        this.nextCoordinates = nextCoordinates;
        this.movementProgress = movementProgress;
    }

    public MovingAbility(GridPoint2 nextCoordinates) {
        this.movementSpeed = GLOBAL_MOVEMENT_SPEED;
        this.nextCoordinates = new GridPoint2(nextCoordinates);
    }

    public MovingAbility(GridPoint2 nextCoordinates, float movementProgress) {
        this(nextCoordinates);
        this.movementProgress = movementProgress;
    }

    public void changeMovementProgress(float deltaTime) {
        movementProgress = continueProgress(movementProgress, deltaTime, movementSpeed);
    }
}
