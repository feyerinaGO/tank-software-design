package ru.mipt.bit.platformer.events;

public interface EventManager {
    void subscribe(EventListener listener);
    void notifyChanges(EventType eventType, Object o);
}
