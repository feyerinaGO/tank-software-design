package ru.mipt.bit.platformer.commands;

import java.util.Collection;

public interface CommandGenerator {
    Collection<Command> generateCommands();
}
