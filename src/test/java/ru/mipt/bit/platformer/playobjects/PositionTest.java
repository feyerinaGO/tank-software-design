package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void getTypeTest() {
        Position position = new Position(new GridPoint2(1,2), TypeGameObjects.TREE);
        assertEquals(position.getType(), TypeGameObjects.TREE, "Wrong type object");
    }

    @Test
    void checkCreationTest() {
        Position position = new Position(new GridPoint2(1,2), TypeGameObjects.TREE);
        assertEquals(position.coordinates.x, 1, "Wrong short constructor x!");
        assertEquals(position.coordinates.y, 2, "Wrong short constructor y!");
        Position position2 = new Position(new GridPoint2(1,2), 90f, TypeGameObjects.TREE);
        assertEquals(position2.coordinates.x, 1, "Wrong short constructor x!");
        assertEquals(position2.coordinates.y, 2, "Wrong short constructor y!");
        assertEquals(position2.rotation, 90f, "Wrong rotation!");
    }

    @Test
    void checkCreationWithRotationTest() {
        Position position = new Position(new GridPoint2(1,2), 90f, TypeGameObjects.TREE);
        assertEquals(position.coordinates.x, 1, "Wrong short constructor x!");
        assertEquals(position.coordinates.y, 2, "Wrong short constructor y!");
        assertEquals(position.rotation, 90f, "Wrong rotation!");
    }
}