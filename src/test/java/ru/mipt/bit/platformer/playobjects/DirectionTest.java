package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void getAngleTest() {
        Direction direction = new Direction(90f, new GridPoint2(2,3));
        assertEquals(direction.getAngle(), 90f, "Wrong angle after creation!");
    }

    @Test
    void getVectorTest() {
        Direction direction = new Direction(90f, new GridPoint2(2,3));
        assertEquals(direction.getVector().x, 2, "Wrong x after creation!");
        assertEquals(direction.getVector().y, 3, "Wrong x after creation!");
    }

    @Test
    void addUpTest() {
        GridPoint2 coordinate = new GridPoint2(1,1);
        GridPoint2 newCoordinate = Direction.add(Direction.UP, coordinate);
        assertEquals(newCoordinate.x, 1, "Wrong x after up!");
        assertEquals(newCoordinate.y, 2, "Wrong x after up!");
    }

    @Test
    void addLeftTest() {
        GridPoint2 coordinate = new GridPoint2(1,1);
        GridPoint2 newCoordinate = Direction.add(Direction.LEFT, coordinate);
        assertEquals(newCoordinate.x, 0, "Wrong x after left!");
        assertEquals(newCoordinate.y, 1, "Wrong x after left!");
    }

    @Test
    void addDownTest() {
        GridPoint2 coordinate = new GridPoint2(1,1);
        GridPoint2 newCoordinate = Direction.add(Direction.DOWN, coordinate);
        assertEquals(newCoordinate.x, 1, "Wrong x after down!");
        assertEquals(newCoordinate.y, 0, "Wrong x after down!");
    }

    @Test
    void addRightTest() {
        GridPoint2 coordinate = new GridPoint2(1,1);
        GridPoint2 newCoordinate = Direction.add(Direction.RIGHT, coordinate);
        assertEquals(newCoordinate.x, 2, "Wrong x after right!");
        assertEquals(newCoordinate.y, 1, "Wrong x after right!");
    }

    @Test
    void getNextDirectionTest() {
        DynamicObject tank = new DynamicObject(new GridPoint2(1,1), TypeGameObjects.ENEMY);
        Direction direction = new Direction().getNextDirection(tank);
        assertNotNull(direction, "Wrong getting next direction for tank");
    }
}