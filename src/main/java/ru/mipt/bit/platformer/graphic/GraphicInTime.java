package ru.mipt.bit.platformer.graphic;

import com.badlogic.gdx.graphics.Texture;
import ru.mipt.bit.platformer.events.EventListener;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.playobjects.Position;
import ru.mipt.bit.platformer.playobjects.StateObject;
import ru.mipt.bit.platformer.playobjects.DynamicObject;

import java.util.ArrayList;
import java.util.HashMap;

import static ru.mipt.bit.platformer.game_data.ConstantSettings.TEXTURES;

public class GraphicInTime implements EventListener {
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
        level.subscribe(this);
    }

    @Override
    public void update(Level level) {
        ArrayList<Position> dynamicPositions = new ArrayList<>();
        HashMap<Position, DynamicObject> dynamics = new HashMap<>();
        for (DynamicObject dynamicObject : level.dynamicObjects) {
            dynamicPositions.add(dynamicObject.position);
            dynamics.put(dynamicObject.position, dynamicObject);
        }
        ArrayList<Graphic> graphicForRemove = new ArrayList<>();
        for (Graphic graphic : graphicDynamicObjects) {
            if (dynamicPositions.contains(graphic.position)) {
                dynamicPositions.remove(graphic.position);
            } else {
                graphicForRemove.add(graphic);
                graphic.texture.dispose();
            }
        }
        for (Graphic graphic : graphicForRemove) {
            graphicDynamicObjects.remove(graphic);
        }
        for (Position position : dynamicPositions) {
            DynamicObject dynamicObject = dynamics.get(position);
            Graphic graphic = new Graphic(new Texture(TEXTURES.get(dynamicObject.position.getType())),
                    dynamicObject.position, dynamicObject.movingAbility);
            graphicDynamicObjects.add(graphic);
        }
    }
}
