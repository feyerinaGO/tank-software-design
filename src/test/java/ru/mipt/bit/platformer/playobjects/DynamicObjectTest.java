package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import static org.junit.jupiter.api.Assertions.*;

class DynamicObjectTest {

    @Test
    void getNewDynamicObjectTest() {
        DynamicObject dynamic = new DynamicObject(new GridPoint2(1,2), 0f, TypeGameObjects.PLAYER);
        assertEquals(dynamic.position.coordinates.x, 1, "Wrong initial x!");
        assertEquals(dynamic.position.coordinates.y, 2, "Wrong initial y!");
        assertEquals(dynamic.movingAbility.nextCoordinates.x, 1, "Wrong x!");
        assertEquals(dynamic.movingAbility.nextCoordinates.y, 2, "Wrong y!");
        assertEquals(dynamic.position.rotation, 0f, "Wrong rotation!");
        assertEquals(dynamic.position.getType(), TypeGameObjects.PLAYER, "Wrong type object");
    }
}