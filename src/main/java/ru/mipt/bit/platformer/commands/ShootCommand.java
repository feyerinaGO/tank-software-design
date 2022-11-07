package ru.mipt.bit.platformer.commands;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.DynamicObjectBullet;
import ru.mipt.bit.platformer.playobjects.Level;

public class ShootCommand implements Command{
    private DynamicObject dynamicObject;
    private Level level;

    public ShootCommand(DynamicObject dynamicObject, Level level) {
        this.dynamicObject = dynamicObject;
        this.level = level;
    }

    @Override
    public void execute() {
        GridPoint2 coordinates = Direction.add(Direction.getDirectionByRotation(dynamicObject.position.rotation),
                dynamicObject.position.coordinates);
        if (DynamicObject.isAbleMove(coordinates, level)) {
            level.dynamicObjects.add(new DynamicObjectBullet(coordinates,
                    dynamicObject.position.rotation));
            level.notifyChanges();
        }
    }
}
