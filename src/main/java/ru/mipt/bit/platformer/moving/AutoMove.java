package ru.mipt.bit.platformer.moving;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;

import java.util.concurrent.ThreadLocalRandom;
import static ru.mipt.bit.platformer.game_data.Constant.WIN_HGT_TILES;
import static ru.mipt.bit.platformer.game_data.Constant.WIN_WDT_TILES;

public class AutoMove implements MoveObject {
    private int direction;
    @Override
    public GridPoint2 getNewCoordinates(Input input, GridPoint2 coordinates) {
        this.direction = ThreadLocalRandom.current().nextInt(1, 5);
        switch (direction) {
            case 1:
                coordinates.y++;
                if (coordinates.y > WIN_HGT_TILES) coordinates.y = WIN_HGT_TILES;
                break;
            case 2:
                coordinates.x--;
                if (coordinates.x < 1) coordinates.x = 1;
                break;
            case 3:
                coordinates.y--;
                if (coordinates.y < 1) coordinates.y = 1;
                break;
            case 4:
                coordinates.x++;
                if (coordinates.x > WIN_WDT_TILES) coordinates.x = WIN_WDT_TILES;
                break;
        }
        return coordinates;
    }

    @Override
    public float getNewRotation(Input input, float rotation) {
        switch (direction) {
            case 1:
                rotation = 90f;
                break;
            case 2:
                rotation = 180f;
                break;
            case 3:
                rotation = -90f;
                break;
            case 4:
                rotation = 0f;
                break;
        }
        return rotation;
    }
}
