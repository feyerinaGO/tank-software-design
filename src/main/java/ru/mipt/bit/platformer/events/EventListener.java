package ru.mipt.bit.platformer.events;

public interface EventListener {
    void update(EventType eventType, Object o);
}
