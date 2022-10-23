package ru.mipt.bit.platformer.levels;
import ru.mipt.bit.platformer.playobjects.Level;

import java.util.HashMap;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.LEVEL_PATH;

public class ContextLevel {
    public static HashMap<VariantLevel, CreateLevel> variants = new HashMap<>();
    public static final CreateLevel RANDOM_LEVEL = new RandomLevel();
    public static final CreateLevel FROM_FILE_LEVEL = new FromFileLevel(LEVEL_PATH);
    private static CreateLevel context;

    static {
        variants.put(VariantLevel.RANDOM, RANDOM_LEVEL);
        variants.put(VariantLevel.FROM_FILE, FROM_FILE_LEVEL);
    }

    public static Level getLevel(VariantLevel variant) {
        setContext(variant);
        return context.getLevel();
    }

    private static void setContext(VariantLevel variant) {
        context = variants.get(variant);
    }
}
