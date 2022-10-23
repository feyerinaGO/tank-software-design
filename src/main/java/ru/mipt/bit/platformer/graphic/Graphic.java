package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.playobjects.*;
import ru.mipt.bit.platformer.util.TileMovement;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;

public class Graphic {
    public final Texture texture;
    public final TextureRegion graphics;
    public final Rectangle rectangle;
    public MovingAbility movingAbility;
    public Position position;

    public Graphic(Texture texture, Position position) {
        this.texture = texture;
        this.graphics = new TextureRegion(this.texture);
        this.rectangle = createBoundingRectangle(this.graphics);
        this.position = position;
    }

    public Graphic(Texture texture, Position position, MovingAbility movingAbility) {
        this(texture, position);
        this.movingAbility = movingAbility;
    }

    public void moveDynamicObjectRectangle(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(rectangle, position.coordinates,
                movingAbility.nextCoordinates, movingAbility.movementProgress);

    }
}
