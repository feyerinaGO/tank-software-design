package ru.mipt.bit.platformer.commands;

import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InertiaMoveGenerator implements CommandGenerator {
        private final Level level;

        public InertiaMoveGenerator(Level level) {
            this.level = level;
        }

        @Override
        public Collection<Command> generateCommands() {
            List<Command> commandList = new ArrayList<>();
            for (DynamicObject dynamic : level.getDynamicObjects()) {
                if (dynamic.position.getType().equals(TypeGameObjects.BULLET)) {
                    commandList.add(new MoveCommand(Direction.getDirectionByRotation(dynamic.position.rotation), dynamic, level));
                }
            }
            return commandList;
        }
}
