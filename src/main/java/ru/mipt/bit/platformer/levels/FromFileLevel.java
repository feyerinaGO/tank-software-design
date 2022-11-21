package ru.mipt.bit.platformer.levels;
import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.GlobalTypeOfObject;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StaticObject;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.*;

public class FromFileLevel implements CreateLevel {
    private final ArrayList<ArrayList<String>> scheme;
    private final static HashMap<String, TypeGameObjects> notations = new HashMap<>();

    static {
        notations.put("T", TypeGameObjects.TREE);
        notations.put("X", TypeGameObjects.PLAYER);
        notations.put("E", TypeGameObjects.ENEMY);
    }

    public FromFileLevel(String path) {
        scheme = new ArrayList<>();
        try {
            String filePath = new File("").getAbsolutePath();
            filePath += path;
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> letters = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    letters.add(line.substring(i,i+1));
                }
                scheme.add(letters);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Level getLevel() {
        Level level = new Level();
        for (int i = 0; i < scheme.size(); i++) {
            for (int j = 0; j < scheme.get(i).size(); j++) {
                if (notations.containsKey(scheme.get(i).get(j))) {
                    TypeGameObjects type = notations.get(scheme.get(i).get(j));
                    GlobalTypeOfObject typeOfObject = GLOBAL_TYPES_OF_OBJECTS.get(type);
                    if (typeOfObject.equals(GlobalTypeOfObject.STATIC)) {
                        level.addStaticObstacles(new StaticObject(new GridPoint2(j, WINDOW_HEIGHT - i - 1), type));
                    } else if (typeOfObject.equals(GlobalTypeOfObject.DYNAMIC)) {
                        level.addDynamicObject(new DynamicObject(new GridPoint2(j, WINDOW_HEIGHT - i - 1), 0f, type));
                    }
                }
            }
        }
        return level;
    }
}
