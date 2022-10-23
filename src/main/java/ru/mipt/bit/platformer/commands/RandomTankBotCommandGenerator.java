package ru.mipt.bit.platformer.commands;

import org.awesome.ai.strategy.NotRecommendingAI;
import ru.mipt.bit.platformer.adapter.AdapterAIDirection;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RandomTankBotCommandGenerator implements CommandGenerator {
    private Level level;

    public RandomTankBotCommandGenerator(Level level) {
        this.level = level;
    }

    @Override
    public Collection<Command> generateCommands() {
        List<Command> commandList = new ArrayList<>();
        AdapterAIDirection adapterAIDirection = new AdapterAIDirection(level, new NotRecommendingAI());
        for (DynamicObject tank : level.dynamicObjects) {
            if (tank.position.getType().equals(TypeGameObjects.ENEMY)) {
                commandList.add(new MoveCommand(adapterAIDirection.getNextDirection(tank), tank, level));
            }
        }

        return commandList;
    }
}
