package ru.mipt.bit.platformer.commands;

import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

public class MoveCommand implements Command{
    private final Direction direction;
    private DynamicObject dynamicObject;
    private Level level;

    public MoveCommand(Direction direction, DynamicObject dynamicObject, Level level) {
        this.direction = direction;
        this.dynamicObject = dynamicObject;
        this.level = level;
    }

    @Override
    public void execute() {
        dynamicObject.move(direction, level);
    }
}
