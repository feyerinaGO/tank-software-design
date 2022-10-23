package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

public class Position {
    public GridPoint2 coordinates;
    public float rotation = 0f;

    private final TypeGameObjects type;

    public Position(GridPoint2 coordinates, float rotation, TypeGameObjects type) {
        this(coordinates, type);
        this.rotation = rotation;
    }
    public Position(GridPoint2 coordinates, TypeGameObjects type) {
        this.coordinates = new GridPoint2(coordinates);
        this.type = type;
    }

    public TypeGameObjects getType() {
        return type;
    }

}
