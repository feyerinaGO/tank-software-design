package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.badlogic.gdx.Input.Keys.*;
import static org.junit.jupiter.api.Assertions.*;

class DynamicObjectTest {
    private final ArrayList<StateObject> staticObstacles = new ArrayList<>();

    @Test
    void getNewDynamicObjectTest() {
        DynamicObject dynamic = new DynamicObject(new GridPoint2(1,2), 0f);
        assertEquals(dynamic.state.initialCoordinates.x, 1, "Wrong initial x!");
        assertEquals(dynamic.state.initialCoordinates.y, 2, "Wrong initial y!");
        assertEquals(dynamic.coordinates.x, 1, "Wrong x!");
        assertEquals(dynamic.coordinates.y, 2, "Wrong y!");
        assertEquals(dynamic.state.rotation, 0f, "Wrong rotation!");
    }

    @Test
    void getNewPositionTest() {
        staticObstacles.add(new StateObject(new GridPoint2(4, 4)));
        DynamicObject dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        Input input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == DOWN;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong DOWN new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong DOWN new y!");
        assertEquals(dynamic.state.rotation, -90f, "Wrong DOWN new rotation!");
        dynamic = new DynamicObject(new GridPoint2(4,5), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong DOWN new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 5, "Wrong DOWN new y!");
        assertEquals(dynamic.state.rotation, -90f, "Wrong DOWN new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == S;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong S new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong S new y!");
        assertEquals(dynamic.state.rotation, -90f, "Wrong S new rotation!");
        dynamic = new DynamicObject(new GridPoint2(4,5), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong S new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 5, "Wrong S new y!");
        assertEquals(dynamic.state.rotation, -90f, "Wrong S new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == UP;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong UP new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 5, "Wrong UP new y!");
        assertEquals(dynamic.state.rotation, 90f, "Wrong UP new rotation!");
        dynamic = new DynamicObject(new GridPoint2(4,3), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong UP new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong UP new y!");
        assertEquals(dynamic.state.rotation, 90f, "Wrong UP new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == W;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong W new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 5, "Wrong W new y!");
        assertEquals(dynamic.state.rotation, 90f, "Wrong W new rotation!");
        dynamic = new DynamicObject(new GridPoint2(4,3), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong W new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong W new y!");
        assertEquals(dynamic.state.rotation, 90f, "Wrong W new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == LEFT;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 2, "Wrong LEFT new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong LEFT new y!");
        assertEquals(dynamic.state.rotation, -180f, "Wrong LEFT new rotation!");
        dynamic = new DynamicObject(new GridPoint2(5,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 5, "Wrong LEFT new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong LEFT new y!");
        assertEquals(dynamic.state.rotation, -180f, "Wrong LEFT new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == A;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 2, "Wrong A new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong A new y!");
        assertEquals(dynamic.state.rotation, -180f, "Wrong A new rotation!");
        dynamic = new DynamicObject(new GridPoint2(5,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 5, "Wrong A new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong A new y!");
        assertEquals(dynamic.state.rotation, -180f, "Wrong A new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == RIGHT;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,3), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong RIGHT new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong RIGHT new y!");
        assertEquals(dynamic.state.rotation, 0f, "Wrong RIGHT new rotation!");
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong RIGHT new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong RIGHT new y!");
        assertEquals(dynamic.state.rotation, 0f, "Wrong RIGHT new rotation!");
        input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == D;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic = new DynamicObject(new GridPoint2(3,3), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 4, "Wrong D new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 3, "Wrong D new y!");
        assertEquals(dynamic.state.rotation, 0f, "Wrong D new rotation!");
        dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        dynamic.getNewPosition(staticObstacles, input, true);
        assertEquals(dynamic.state.initialCoordinates.x, 3, "Wrong D new x!");
        assertEquals(dynamic.state.initialCoordinates.y, 4, "Wrong D new y!");
        assertEquals(dynamic.state.rotation, 0f, "Wrong D new rotation!");
    }

    @Test
    void calculatePlayerCoordinatesTest() {
        DynamicObject dynamic = new DynamicObject(new GridPoint2(3,4), 0f);
        Input input = new Input() {
            @Override
            public boolean isKeyPressed(int key) {
                return key == DOWN;
            }
            @Override
            public float getAccelerometerX() {
                return 0;
            }

            @Override
            public float getAccelerometerY() {
                return 0;
            }

            @Override
            public float getAccelerometerZ() {
                return 0;
            }

            @Override
            public float getGyroscopeX() {
                return 0;
            }

            @Override
            public float getGyroscopeY() {
                return 0;
            }

            @Override
            public float getGyroscopeZ() {
                return 0;
            }

            @Override
            public int getMaxPointers() {
                return 0;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getX(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaX() {
                return 0;
            }

            @Override
            public int getDeltaX(int pointer) {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getY(int pointer) {
                return 0;
            }

            @Override
            public int getDeltaY() {
                return 0;
            }

            @Override
            public int getDeltaY(int pointer) {
                return 0;
            }

            @Override
            public boolean isTouched() {
                return false;
            }

            @Override
            public boolean justTouched() {
                return false;
            }

            @Override
            public boolean isTouched(int pointer) {
                return false;
            }

            @Override
            public float getPressure() {
                return 0;
            }

            @Override
            public float getPressure(int pointer) {
                return 0;
            }

            @Override
            public boolean isButtonPressed(int button) {
                return false;
            }

            @Override
            public boolean isButtonJustPressed(int button) {
                return false;
            }

            @Override
            public boolean isKeyJustPressed(int key) {
                return false;
            }

            @Override
            public void getTextInput(TextInputListener listener, String title, String text, String hint) {

            }

            @Override
            public void setOnscreenKeyboardVisible(boolean visible) {

            }

            @Override
            public void vibrate(int milliseconds) {

            }

            @Override
            public void vibrate(long[] pattern, int repeat) {

            }

            @Override
            public void cancelVibrate() {

            }

            @Override
            public float getAzimuth() {
                return 0;
            }

            @Override
            public float getPitch() {
                return 0;
            }

            @Override
            public float getRoll() {
                return 0;
            }

            @Override
            public void getRotationMatrix(float[] matrix) {

            }

            @Override
            public long getCurrentEventTime() {
                return 0;
            }

            @Override
            public void setCatchBackKey(boolean catchBack) {

            }

            @Override
            public boolean isCatchBackKey() {
                return false;
            }

            @Override
            public void setCatchMenuKey(boolean catchMenu) {

            }

            @Override
            public boolean isCatchMenuKey() {
                return false;
            }

            @Override
            public void setCatchKey(int keycode, boolean catchKey) {

            }

            @Override
            public boolean isCatchKey(int keycode) {
                return false;
            }

            @Override
            public void setInputProcessor(InputProcessor processor) {

            }

            @Override
            public InputProcessor getInputProcessor() {
                return null;
            }

            @Override
            public boolean isPeripheralAvailable(Peripheral peripheral) {
                return false;
            }

            @Override
            public int getRotation() {
                return 0;
            }

            @Override
            public Orientation getNativeOrientation() {
                return null;
            }

            @Override
            public void setCursorCatched(boolean catched) {

            }

            @Override
            public boolean isCursorCatched() {
                return false;
            }

            @Override
            public void setCursorPosition(int x, int y) {

            }
        };
        dynamic.getNewPosition(staticObstacles, input, true);
        dynamic.calculatePlayerCoordinates(5f);
        assertEquals(dynamic.coordinates.x, 3, "Wrong DOWN new x!");
        assertEquals(dynamic.coordinates.y, 3, "Wrong DOWN new y!");
        assertEquals(dynamic.state.rotation, -90f, "Wrong DOWN new rotation!");
    }
}