package ru.mipt.bit.platformer.state;

public class LightState implements TankState{
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

    public LightState(float initialMovementSpeed) {
        this.movementSpeed = initialMovementSpeed;
        this.isAbleShoot = true;
    }
}
