package ru.mipt.bit.platformer.game_data;

import ru.mipt.bit.platformer.levels.VariantLevel;

import java.util.HashMap;

public class ConstantSettings {
    public static final int WINDOW_WIDTH = 10;
    public static final int WINDOW_HEIGHT = 8;
    public static final int COUNT_PLAYERS = 1;
    public static final int COUNT_ENEMIES = 0;
    public static final String LEVEL_PATH = "\\src\\main\\resources\\level_files\\level_1.txt";
    public static final float GLOBAL_MOVEMENT_SPEED = 0.4f;
    public static final float GLOBAL_ACCELERATION = 1f;
    public static final VariantLevel VARIANT_LEVEL = VariantLevel.FROM_FILE;
    public static HashMap<TypeGameObjects, String> TEXTURES = new HashMap<>();
    public static HashMap<TypeGameObjects, Integer> HEALTHY_START = new HashMap<>();
    public static HashMap<TypeGameObjects, GlobalTypeOfObject> GLOBAL_TYPES_OF_OBJECTS = new HashMap<>();

    static {
        TEXTURES.put(TypeGameObjects.TREE, "images/greenTree.png");
        TEXTURES.put(TypeGameObjects.PLAYER, "images/tank_blue.png");
        TEXTURES.put(TypeGameObjects.ENEMY, "images/tank_blue.png");
        TEXTURES.put(TypeGameObjects.BULLET, "images/bullet.png");
        GLOBAL_TYPES_OF_OBJECTS.put(TypeGameObjects.TREE, GlobalTypeOfObject.STATIC);
        GLOBAL_TYPES_OF_OBJECTS.put(TypeGameObjects.PLAYER, GlobalTypeOfObject.DYNAMIC);
        GLOBAL_TYPES_OF_OBJECTS.put(TypeGameObjects.ENEMY, GlobalTypeOfObject.DYNAMIC);
        GLOBAL_TYPES_OF_OBJECTS.put(TypeGameObjects.BULLET, GlobalTypeOfObject.DYNAMIC);
        HEALTHY_START.put(TypeGameObjects.TREE, 1);
        HEALTHY_START.put(TypeGameObjects.PLAYER, 100);
        HEALTHY_START.put(TypeGameObjects.ENEMY, 100);
        HEALTHY_START.put(TypeGameObjects.BULLET, 1);
    }
}
