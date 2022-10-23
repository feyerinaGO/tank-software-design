package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Texture;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StateObject;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.util.ArrayList;

import static ru.mipt.bit.platformer.game_data.Constant.TEXTURES;

public class GraphicInTime {
    public ArrayList<Graphic> graphicStaticObjects = new ArrayList<>();
    public ArrayList<Graphic> graphicDynamicObjects = new ArrayList<>();

    public GraphicInTime(Level level) {
        for (StateObject obstacle : level.staticObstacles) {
            graphicStaticObjects.add(new Graphic(new Texture(TEXTURES.get(obstacle.position.getType())),
                    obstacle.position));
        }
        for (DynamicObject dynamicObject : level.dynamicObjects) {
            graphicDynamicObjects.add(new Graphic(new Texture(TEXTURES.get(dynamicObject.position.getType())),
                    dynamicObject.position, dynamicObject.movingAbility));
        }
    }
}
