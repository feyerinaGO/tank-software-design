package ru.mipt.bit.platformer.commands;

import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;

public class ShootCommand implements Command{
    private final DynamicObject dynamicObject;
    private final Level level;

    public ShootCommand(DynamicObject dynamicObject, Level level) {
        this.dynamicObject = dynamicObject;
        this.level = level;
    }

    @Override
    public void execute() {
        dynamicObject.shoot(level);
    }
}
