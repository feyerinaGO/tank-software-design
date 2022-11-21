package ru.mipt.bit.platformer.state;

public class HeavyState implements TankState{
    private final float movementSpeed;
    private final boolean isAbleShoot;

    @Override
    public float getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public float getShootSpeed() {
        return 0;
    }

    @Override
    public boolean getAbilityShoot() {
        return this.isAbleShoot;
    }

    public HeavyState(float initialMovementSpeed) {
        this.movementSpeed = initialMovementSpeed / 3;
        this.isAbleShoot = false;
    }
}
