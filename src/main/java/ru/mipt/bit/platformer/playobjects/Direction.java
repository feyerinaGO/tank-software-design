package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;

public class Direction {
    private final float angle;
    private final GridPoint2 vector;

    public static Direction UP = new Direction(90f, new GridPoint2(0, 1));
    public static Direction LEFT = new Direction(180f, new GridPoint2(-1, 0));
    public static Direction DOWN = new Direction(-90f, new GridPoint2(0, -1));
    public static Direction RIGHT = new Direction(0f, new GridPoint2(1, 0));

    public Direction(float angle, GridPoint2 vector) {
        this.angle = angle;
        this.vector = vector;
    }
    public Direction() {
        this.angle = 0f;
        this.vector = new GridPoint2(0, 0);
    }

    public float getAngle() {
        return angle;
    }

    public GridPoint2 getVector() {
        return vector;
    }

    public static GridPoint2 add(Direction direction, GridPoint2 coordinates) {
        GridPoint2 newCoordinates = new GridPoint2(coordinates);
        newCoordinates.add(direction.getVector());
        return newCoordinates;
    }

    public static Direction getDirectionByRotation(float rotation) {
        if (rotation==180f || rotation==-180f) {
            return LEFT;
        } else if (rotation==-90f) {
            return DOWN;
        } else if (rotation==0f) {
            return RIGHT;
        } else {
            return UP;
        }
    }


}
