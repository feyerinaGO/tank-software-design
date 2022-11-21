package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Texture;
import ru.mipt.bit.platformer.events.EventListener;
import ru.mipt.bit.platformer.events.EventType;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.StaticObject;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.util.ArrayList;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.TEXTURES;

public class GraphicInTime implements EventListener {
    public ArrayList<Graphic> graphicStaticObjects = new ArrayList<>();
    public ArrayList<Graphic> graphicDynamicObjects = new ArrayList<>();

    public GraphicInTime(Level level) {
        for (StaticObject obstacle : level.getStaticObstacles()) {
            graphicStaticObjects.add(new Graphic(new Texture(TEXTURES.get(obstacle.position.getType())),
                    obstacle.position));
        }
        for (DynamicObject dynamicObject : level.getDynamicObjects()) {
            graphicDynamicObjects.add(new Graphic(new Texture(TEXTURES.get(dynamicObject.position.getType())),
                    dynamicObject.position, dynamicObject.movingAbility));
        }
        level.subscribe(this);
    }

    @Override
    public void update(EventType eventType, Object o) {
        if (eventType.equals(EventType.ADD_STATIC)) {
            StaticObject obstacle = (StaticObject) o;
            graphicStaticObjects.add(new Graphic(new Texture(TEXTURES.get(obstacle.position.getType())),
                    obstacle.position));
        } else if (eventType.equals(EventType.ADD_DYNAMIC)) {
            DynamicObject dynamicObject = (DynamicObject) o;
            graphicDynamicObjects.add(new Graphic(new Texture(TEXTURES.get(dynamicObject.position.getType())),
                    dynamicObject.position, dynamicObject.movingAbility));
        } else if (eventType.equals(EventType.REMOVE_DYNAMIC)) {
            DynamicObject dynamicObject = (DynamicObject) o;
            ArrayList<Graphic> forRemove = new ArrayList<>();
            for (Graphic graphic : graphicDynamicObjects) {
                if (dynamicObject.position.equals(graphic.position)) {
                    forRemove.add(graphic);
                    graphic.texture.dispose();
                }
            }
            for (Graphic graphic : forRemove) {
                graphicDynamicObjects.remove(graphic);
            }
        }
    }
}
