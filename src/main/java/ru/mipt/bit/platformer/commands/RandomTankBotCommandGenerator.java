package ru.mipt.bit.platformer.commands;

import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTankBotCommandGenerator implements CommandGenerator {
    private Level level;

    public RandomTankBotCommandGenerator(Level level) {
        this.level = level;
    }

    @Override
    public Collection<Command> generateCommands() {
        List<Command> commandList = new ArrayList<>();
        for (DynamicObject tank : level.dynamicObjects) {
            if (tank.position.getType().equals(TypeGameObjects.ENEMY)) {
                commandList.add(new MoveCommand(getRandomDirection(), tank, level));
            }
        }

        return commandList;
    }

    private Direction getRandomDirection() {
        Direction direction = Direction.UP;
        int randInt = ThreadLocalRandom.current().nextInt(1, 5);
        switch (randInt) {
            case 2:
                direction = Direction.LEFT;
                break;
            case 3:
                direction = Direction.DOWN;
                break;
            case 4:
                direction = Direction.RIGHT;
                break;
        }
        return direction;
    }
}
