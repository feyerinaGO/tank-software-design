package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Interpolation;
import ru.mipt.bit.platformer.graphic.Graphic;
import ru.mipt.bit.platformer.levels.ContextLevel;
import ru.mipt.bit.platformer.playobjects.DynamicObject;
import ru.mipt.bit.platformer.playobjects.StateObject;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.ArrayList;
import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static ru.mipt.bit.platformer.game_data.Constant.*;
import static ru.mipt.bit.platformer.game_data.Obstacles.obstaclesCoordinates;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class GameDesktopLauncher implements ApplicationListener {
    private Batch batch;

    private TiledMap level;
    private MapRenderer levelRenderer;
    private TileMovement tileMovement;
    private TiledMapTileLayer groundLayer;

    private final ArrayList<DynamicObject> players = new ArrayList<>();
    private final ArrayList<DynamicObject> enemies = new ArrayList<>();
    private final ArrayList<StateObject> staticObstacles = new ArrayList<>();
    private final ArrayList<Graphic> graphicStaticObjects = new ArrayList<>();
    private final ArrayList<Graphic> graphicDynamicObjects = new ArrayList<>();

    @Override
    public void create() {
        initializeParams();
        createGameObjects(USING_RANDOM);
        createGraphicObjects();
        moveInitialStaticObject();
    }

    private void createGameObjects(boolean random) {
        if (random) {
            ContextLevel.setContext(ContextLevel.RANDOM);
        } else {
            ContextLevel.setContext(ContextLevel.FROM_FILE);
        }
        createDynamicObjects();
        createStaticObstacles();
    }

    @Override
    public void render() {
        clearScreen();
        moveDynamicObjects();
        levelRenderer.render();
        drawGraphics();
    }

    private void moveDynamicObjects() {
        fillObstacles();
        for (DynamicObject el: players) {
            el.getNewPosition(staticObstacles, Gdx.input, true);
            el.calculatePlayerCoordinates(Gdx.graphics.getDeltaTime());
        }
        for (DynamicObject el: enemies) {
            el.getNewPosition(staticObstacles, Gdx.input, true);
            el.calculatePlayerCoordinates(Gdx.graphics.getDeltaTime());
        }
        clearObstacles();
        moveDynamicObjectsRectangle();
    }

    private void clearObstacles() {
        obstaclesCoordinates.clear();
    }

    private void fillObstacles() {
        for (DynamicObject el: players) {
            obstaclesCoordinates.add(el.state.initialCoordinates);
        }
        for (DynamicObject el: enemies) {
            obstaclesCoordinates.add(el.state.initialCoordinates);
        }
    }

    private void initializeParams() {
        batch = new SpriteBatch();
        level = new TmxMapLoader().load("level.tmx");
        levelRenderer = createSingleLayerMapRenderer(level, batch);
        groundLayer = getSingleLayer(level);
        tileMovement = new TileMovement(groundLayer, Interpolation.smooth);
    }

    private void moveInitialStaticObject() {
        for (Graphic graphic : graphicStaticObjects) {
            moveRectangleAtTileCenter(groundLayer, graphic.rectangle,
                    graphic.state.initialCoordinates);
        }
    }

    private void createStaticObstacles() {
        var obstaclesCoordinates = ContextLevel.getObstaclesCoordinates();
        for (GridPoint2 gp : obstaclesCoordinates) {
            staticObstacles.add(new StateObject(gp, 0f));
        }
    }

    private void createDynamicObjects() {
        var playersCoordinates = ContextLevel.getPlayersCoordinates();
        for (GridPoint2 gp : playersCoordinates) {
            players.add(new DynamicObject(gp, 0f));
        }
        var enemiesCoordinates = ContextLevel.getEnemiesCoordinates();
        for (GridPoint2 gp : enemiesCoordinates) {
            enemies.add(new DynamicObject(gp, 0f));
        }
    }

    private void createGraphicStaticObjects() {
        for (StateObject obstacle : staticObstacles) {
            graphicStaticObjects.add(new Graphic(new Texture("images/greenTree.png"),
                    obstacle));
        }
    }

    private void createGraphicDynamicObjects() {
        for (DynamicObject el: players) {
            graphicDynamicObjects.add(new Graphic(new Texture("images/tank_blue.png"), el));
        }
        for (DynamicObject el: enemies) {
            graphicDynamicObjects.add(new Graphic(new Texture("images/tank_blue.png"), el));
        }
    }

    private void createGraphicObjects() {
        createGraphicStaticObjects();
        createGraphicDynamicObjects();
    }

    private void moveDynamicObjectsRectangle() {
        for (Graphic graphic : graphicDynamicObjects) {
            graphic.moveDynamicObjectRectangle(tileMovement);
        }

    }

    private void drawGraphics() {
        // start recording all drawing commands
        batch.begin();

        drawGraphicObjects(batch, graphicDynamicObjects);
        drawGraphicObjects(batch, graphicStaticObjects);
        // submit all drawing requests
        batch.end();
    }

    private void drawGraphicObjects(Batch batch, List<Graphic> graphicList) {
        for (Graphic graphic : graphicList) {
            drawTextureRegionUnscaled(batch, graphic.graphics, graphic.rectangle,
                    graphic.state.rotation);
        }
    }

    private static void clearScreen() {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
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
        disposeObjects(graphicStaticObjects);
        disposeObjects(graphicDynamicObjects);
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
        config.setWindowedMode(128*WIN_WDT_TILES, 128*WIN_HGT_TILES);
        new Lwjgl3Application(new GameDesktopLauncher(), config);
    }
}
