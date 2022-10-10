package ru.mipt.bit.platformer.moving;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

public class ContextMove {
    public static MoveObject PLAYER = new PlayerMove();
    public static MoveObject ENEMY = new AutoMove();
    private static MoveObject context;

    public static void setContext(MoveObject context) {
        ContextMove.context = context;
    }

    public static GridPoint2 getNewCoordinates(Input input, GridPoint2 coordinates) {
        return context.getNewCoordinates(input, coordinates);
    }

    public static float getNewRotation(Input input, float rotation) {
        return context.getNewRotation(input, rotation);
    }
}
