package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Color;
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
    public HealthBar healthy;
    public HealthBar healthMax;

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
                movingAbility.nextCoordinates, movingAbility.getMovementProgress());

    }

    public void setProgressBar(){
        float healthWidth = 128f*position.getHealthLevel()/position.getMaxHealthLevel();
        healthy = new HealthBar((int)healthWidth, 20, Color.GREEN);
        healthy.setPosition(128*position.coordinates.x, 128*(position.coordinates.y+1));
        healthMax = new HealthBar((int)(128-healthWidth), 20, Color.RED);
        healthMax.setPosition(128*position.coordinates.x+(int)healthWidth, 128*(position.coordinates.y+1));
    }

}
