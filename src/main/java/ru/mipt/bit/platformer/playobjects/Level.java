package ru.mipt.bit.platformer.playobjects;
import ru.mipt.bit.platformer.events.EventListener;
import ru.mipt.bit.platformer.events.EventManager;

import java.util.ArrayList;

public class Level implements EventManager {
    public ArrayList<StateObject> staticObstacles = new ArrayList<>();
    public ArrayList<DynamicObject> dynamicObjects = new ArrayList<>();
    private ArrayList<EventListener> listeners = new ArrayList<>();

    public void update() {
        boolean isChanges = false;
        ArrayList<DynamicObject> forRemoving = new ArrayList<>();
        for (DynamicObject dynamicObject : dynamicObjects) {
            if (dynamicObject.position.getHealthLevel() < 1) {
                forRemoving.add(dynamicObject);
            }
        }
        for (DynamicObject dynamicObject : forRemoving) {
            dynamicObjects.remove(dynamicObject);
            isChanges = true;
        }
        if (isChanges) {
            notifyChanges();
        }
    }

    @Override
    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyChanges() {
        for (EventListener listener : listeners) {
            listener.update(this);
        }
    }
}
