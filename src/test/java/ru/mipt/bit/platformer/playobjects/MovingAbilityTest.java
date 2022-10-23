package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingAbilityTest {

    @Test
    void changeMovementProgress() {
        MovingAbility movingAbility = new MovingAbility(new GridPoint2(1,2), 0f);
        assertEquals(movingAbility.movementProgress, 0f, "Wrong movement progress after creation!");
        assertEquals(movingAbility.nextCoordinates.x, 1, "Wrong x after creation!");
        assertEquals(movingAbility.nextCoordinates.y, 2, "Wrong x after creation!");
        movingAbility.changeMovementProgress(1f);
        assertEquals(movingAbility.movementProgress, 1f, "Wrong movement progress after changing!");
    }
}
