package ru.mipt.bit.platformer.state;

public class MiddleState implements TankState{
    private final float movementSpeed;
    private final boolean isAbleShoot;
    @Override
    public float getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public float getShootSpeed() {
        return 0.5f;
    }

    @Override
    public boolean getAbilityShoot() {
        return this.isAbleShoot;
    }

    public MiddleState(float initialMovementSpeed) {
        this.movementSpeed = initialMovementSpeed / 2;
        this.isAbleShoot = true;
    }
}
