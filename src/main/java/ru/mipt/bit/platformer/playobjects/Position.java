package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.HEALTHY_START;

public class Position {
    public GridPoint2 coordinates;
    public float rotation = 0f;
    private int healthLevel;
    private final int maxHealthLevel;
    private boolean needDecrease = false;
    private final TypeGameObjects type;

    public Position(GridPoint2 coordinates, float rotation, TypeGameObjects type) {
        this(coordinates, type);
        this.rotation = rotation;
    }
    public Position(GridPoint2 coordinates, TypeGameObjects type) {
        this.coordinates = new GridPoint2(coordinates);
        this.type = type;
        this.maxHealthLevel = HEALTHY_START.get(this.type);
        this.healthLevel = this.maxHealthLevel;
    }

    public TypeGameObjects getType() {
        return type;
    }

    public void decreaseHealthLevel() {
        this.healthLevel--;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public boolean isNeedDecrease() {
        return needDecrease;
    }

    public void setNeedDecrease(boolean needDecrease) {
        this.needDecrease = needDecrease;
    }

    public int getMaxHealthLevel() {
        return maxHealthLevel;
    }

}
