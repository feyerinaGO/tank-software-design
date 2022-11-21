package ru.mipt.bit.platformer.state;

public interface TankState {
    float getMovementSpeed();
    float getShootSpeed();
    boolean getAbilityShoot();

    static TankState getState(int health, int maxHealth, float initialMovementSpeed) {
        if (health >= 0.7f * maxHealth) {
            return new LightState(initialMovementSpeed);
        } else if (0.15f * maxHealth <= health) {
            return new MiddleState(initialMovementSpeed);
        } else {
            return new HeavyState(initialMovementSpeed);
        }
    }
}
