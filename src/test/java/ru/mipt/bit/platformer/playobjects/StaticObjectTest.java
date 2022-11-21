package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static org.junit.jupiter.api.Assertions.*;

class StaticObjectTest {
    @Test
    void getNewStateObjectTest() {
        StaticObject state = new StaticObject(new GridPoint2(1,2), TypeGameObjects.TREE);
        assertEquals(state.position.coordinates.x, 1, "Wrong short constructor x!");
        assertEquals(state.position.coordinates.y, 2, "Wrong short constructor y!");
        assertEquals(state.position.getType(), TypeGameObjects.TREE, "Wrong type object");
        StaticObject state2 = new StaticObject(new GridPoint2(1,2), 90f, TypeGameObjects.TREE);
        assertEquals(state2.position.coordinates.x, 1, "Wrong long constructor x!");
        assertEquals(state2.position.coordinates.y, 2, "Wrong long constructor y!");
        assertEquals(state2.position.rotation, 90f, "Wrong rotation!");
        assertEquals(state.position.getType(), TypeGameObjects.TREE, "Wrong type object");
    }
}