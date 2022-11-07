package ru.mipt.bit.platformer.events;

import ru.mipt.bit.platformer.playobjects.Level;

public interface EventListener {
    void update(Level level);
}
