package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Interpolation;
import ru.mipt.bit.platformer.commands.*;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.graphic.Graphic;
import ru.mipt.bit.platformer.graphic.GraphicInTime;
import ru.mipt.bit.platformer.levels.ContextLevel;
import ru.mipt.bit.platformer.levels.VariantLevel;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.Level;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.*;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class GameDesktopLauncher implements ApplicationListener {
    private Batch batch;

    private TiledMap level;
    private MapRenderer levelRenderer;
    private TileMovement tileMovement;
    private TiledMapTileLayer groundLayer;

    private Level gameLevel = new Level();
    private GraphicInTime graphicInTime;

    private final ArrayList<CommandGenerator> commandGenerators = new ArrayList<>();

    @Override
    public void create() {
        initializeParams();
        createGameObjects(VARIANT_LEVEL);
        createCommandGenerators();
        createGraphicObjects();
        moveInitialStaticObject();
    }

    @Override
    public void render() {
        clearScreen();
        handleCommands();
        gameLevel.update();
        live(); // live deltaTime
        levelRenderer.render();
        drawGraphics();
    }

    private void initializeParams() {
        batch = new SpriteBatch();
        level = new TmxMapLoader().load("level.tmx");
        levelRenderer = createSingleLayerMapRenderer(level, batch);
        groundLayer = getSingleLayer(level);
        tileMovement = new TileMovement(groundLayer, Interpolation.smooth);
    }

    private void createGameObjects(VariantLevel variant) {
        gameLevel = ContextLevel.getLevel(variant);
    }

    private void createCommandGenerators() {
        for (DynamicObject dynamicObject : gameLevel.dynamicObjects) {
            if (dynamicObject.position.getType().equals(TypeGameObjects.PLAYER)) {
                commandGenerators.add(new UserInputBasedCommandGenerator(dynamicObject, gameLevel));
                break;
            }
        }
        commandGenerators.add(new RandomTankBotCommandGenerator(gameLevel));
//        commandGenerators.add(new AIBasedCommandGenerator(gameLevel));
        commandGenerators.add(new InertiaMoveGenerator(gameLevel));
    }

    private void createGraphicObjects() {
        graphicInTime = new GraphicInTime(gameLevel);
    }

    private void moveInitialStaticObject() {
        for (Graphic graphic : graphicInTime.graphicStaticObjects) {
            moveRectangleAtTileCenter(groundLayer, graphic.rectangle,
                    graphic.position.coordinates);

        }
    }

    private static void clearScreen() {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
    }

    private void handleCommands() {
        for (CommandGenerator cmdGen : commandGenerators) {
            for (Command cmd : cmdGen.generateCommands()) {
                cmd.execute();
            }
        }
    }

    private void live() {
        for (DynamicObject dynamicObject : gameLevel.dynamicObjects) {
            dynamicObject.takeChanges(Gdx.graphics.getDeltaTime());
        }
        moveDynamicObjectsRectangle();
    }

    private void moveDynamicObjectsRectangle() {
        for (Graphic graphic : graphicInTime.graphicDynamicObjects) {
            graphic.moveDynamicObjectRectangle(tileMovement);
        }

    }

    private void drawGraphics() {
        // start recording all drawing commands
        batch.begin();

        drawGraphicObjects(batch, graphicInTime.graphicDynamicObjects);
        drawGraphicObjects(batch, graphicInTime.graphicStaticObjects);
        // submit all drawing requests
        batch.end();
    }

    private void drawGraphicObjects(Batch batch, List<Graphic> graphicList) {
        for (Graphic graphic : graphicList) {
            drawTextureRegionUnscaled(batch, graphic.graphics, graphic.rectangle,
                    graphic.position.rotation);
        }
    }

    @Override
    public void resize(int width, int height) {
        // do not react to window resizing
    }

    @Override
    public void pause() {
        // game doesn't get paused
    }

    @Override
    public void resume() {
        // game doesn't get paused
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (classes which implement com.badlogic.gdx.utils.Disposable)
        disposeObjects(graphicInTime.graphicStaticObjects);
        disposeObjects(graphicInTime.graphicDynamicObjects);
        level.dispose();
        batch.dispose();
    }

    private void disposeObjects( List<Graphic> graphicList) {
        for (Graphic graphic : graphicList) {
            graphic.texture.dispose();
        }
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        // level width: 10 tiles x 128px, height: 8 tiles x 128px
        config.setWindowedMode(128* WINDOW_WIDTH, 128* WINDOW_HEIGHT);
        new Lwjgl3Application(new GameDesktopLauncher(), config);
    }
}
