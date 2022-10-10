package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.StateObject;
import ru.mipt.bit.platformer.util.TileMovement;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;

public class Graphic {
    public final Texture texture;
    public final TextureRegion graphics;
    public final Rectangle rectangle;
    public StateObject state;
    public DynamicObject dynamic;

    public Graphic(Texture texture, StateObject state) {
        this.texture = texture;
        this.graphics = new TextureRegion(this.texture);
        this.rectangle = createBoundingRectangle(this.graphics);
        this.state = state;
    }

    public Graphic(Texture texture, DynamicObject dynamic) {
        this(texture, dynamic.state);
        this.dynamic = dynamic;
    }

    public void moveDynamicObjectRectangle(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(rectangle, dynamic.coordinates,
                state.initialCoordinates, dynamic.movementProgress);

    }
}
