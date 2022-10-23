package ru.mipt.bit.platformer.playobjects;

import java.util.ArrayList;

public class Level {
    public ArrayList<StateObject> staticObstacles = new ArrayList<>();
    public ArrayList<DynamicObject> dynamicObjects = new ArrayList<>();
}
