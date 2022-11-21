package ru.mipt.bit.platformer.commands;

import ru.mipt.bit.platformer.playobjects.Level;

public class ShowHideProgressBarCommand implements Command{
    private final Level level;

    public ShowHideProgressBarCommand(Level level) {
        this.level = level;
    }
    @Override
    public void execute() {
        level.setShowProgressBar(!level.isShowProgressBar());
    }
}
