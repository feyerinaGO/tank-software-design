package ru.mipt.bit.platformer.playobjects;
import ru.mipt.bit.platformer.events.EventListener;
import ru.mipt.bit.platformer.events.EventManager;
import ru.mipt.bit.platformer.events.EventType;

import java.util.ArrayList;

public class Level implements EventManager {
    private final ArrayList<StaticObject> staticObstacles = new ArrayList<>();
    private final ArrayList<DynamicObject> dynamicObjects = new ArrayList<>();
    private final ArrayList<EventListener> listeners = new ArrayList<>();

    public void addDynamicObject(DynamicObject dynamicObject){
        dynamicObjects.add(dynamicObject);
        notifyChanges(EventType.ADD_DYNAMIC, dynamicObject);
    }

    public void addStaticObstacles(StaticObject staticObject){
        staticObstacles.add(staticObject);
        notifyChanges(EventType.ADD_STATIC, staticObject);
    }

    public ArrayList<StaticObject> getStaticObstacles() {
        return staticObstacles;
    }

    public ArrayList<DynamicObject> getDynamicObjects() {
        return dynamicObjects;
    }

    public void removeDynamicObject(DynamicObject dynamicObject){
        dynamicObjects.remove(dynamicObject);
        notifyChanges(EventType.REMOVE_DYNAMIC, dynamicObject);
    }

    public void update() {
        ArrayList<DynamicObject> forRemove = new ArrayList<>();
        for (DynamicObject dynamicObject : dynamicObjects) {
            if (dynamicObject.position.getHealthLevel() < 1) {
                forRemove.add(dynamicObject);
            }
        }
        for (DynamicObject dynamicObject : forRemove) {
            removeDynamicObject(dynamicObject);
        }
    }

    @Override
    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }


    @Override
    public void notifyChanges(EventType eventType, Object o) {
        for (EventListener listener : listeners) {
            listener.update(eventType, o);
        }
    }
}
