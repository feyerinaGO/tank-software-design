package ru.mipt.bit.platformer.commands;

import com.badlogic.gdx.Gdx;
import ru.mipt.bit.platformer.playobjects.Direction;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.Input.Keys.D;

public class UserInputBasedCommandGenerator implements CommandGenerator{
    private DynamicObject dynamicObject;
    private Level level;

    public UserInputBasedCommandGenerator(DynamicObject dynamicObject, Level level) {
        this.level = level;
        this.dynamicObject = dynamicObject;
    }

    @Override
    public Collection<Command> generateCommands() {
        List<Command> commandList = new ArrayList<>();
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            commandList.add(new MoveCommand(Direction.UP, dynamicObject, level));
        } else if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            commandList.add(new MoveCommand(Direction.LEFT, dynamicObject, level));
        } else if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            commandList.add(new MoveCommand(Direction.DOWN, dynamicObject, level));
        } else if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            commandList.add(new MoveCommand(Direction.RIGHT, dynamicObject, level));
        }
        if (Gdx.input.isKeyJustPressed(SPACE)) {
            commandList.add(new ShootCommand(dynamicObject, level));
        }
        return commandList;
    }
}
