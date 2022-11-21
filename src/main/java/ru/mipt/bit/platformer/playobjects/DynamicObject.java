package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;
import ru.mipt.bit.platformer.state.LightState;
import ru.mipt.bit.platformer.state.TankState;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.*;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public class DynamicObject {
    public Position position;
    public MovingAbility movingAbility;
    public TankState currentState;
    private float shootingProgress;


    public DynamicObject(GridPoint2 initialCoordinates, float rotation, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, rotation, type);
        this.movingAbility = new MovingAbility(new GridPoint2(this.position.coordinates));
        this.currentState = new LightState(GLOBAL_MOVEMENT_SPEED);
        this.shootingProgress = 1f;
   }

    public DynamicObject(GridPoint2 initialCoordinates, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, type);
        this.movingAbility = new MovingAbility(new GridPoint2(this.position.coordinates));
        this.currentState = new LightState(GLOBAL_MOVEMENT_SPEED);
        this.shootingProgress = 1f;
    }

    public DynamicObject(GridPoint2 initialCoordinates, float rotation, float movementSpeed, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, rotation, type);
        this.movingAbility = new MovingAbility(movementSpeed, new GridPoint2(this.position.coordinates));
        this.currentState = new LightState(GLOBAL_MOVEMENT_SPEED);
        this.shootingProgress = 1f;
    }

    public static boolean isAbleMove(GridPoint2 coordinates, Level level) {
        for (StaticObject obstacle : level.getStaticObstacles()) {
            if (obstacle.position.coordinates.equals(coordinates)) {
                return false;
            }
        }
        for (DynamicObject dynamicObject : level.getDynamicObjects()) {
            if ((dynamicObject.position.coordinates.equals(coordinates)) ||
                    (dynamicObject.movingAbility.nextCoordinates.equals(coordinates))) {
                return false;
            }
        }
        return true;
    }

    public void move(Direction direction, Level level) {
        if (!isEqual(movingAbility.getMovementProgress(), 1f)) { return; }
        GridPoint2 newCoordinates = Direction.add(direction, position.coordinates);
        GridPoint2 newCorrectedCoordinates = correctWithBorders(newCoordinates);
        position.rotation = direction.getAngle();
        if (isAbleMove(newCorrectedCoordinates, level)) {
            movingAbility.nextCoordinates.set(newCorrectedCoordinates);
            movingAbility.setMovementProgress(0f);
        }
    }

    public void takeChanges(float deltaTime) {
        this.changeMovementProgress(deltaTime);
        this.changeShootingProgress(deltaTime);
        if (isEqual(movingAbility.getMovementProgress(), 1f)) {
            position.coordinates.set(movingAbility.nextCoordinates);
            if (position.isNeedDecrease()) {
                position.decreaseHealthLevel();
                this.currentState = TankState.getState(position.getHealthLevel(), position.getMaxHealthLevel(),
                        movingAbility.getInitialMovementSpeed());
            }
        }
        position.setNeedDecrease(false);
    }

    protected GridPoint2 correctWithBorders(GridPoint2 coordinates) {
        GridPoint2 newCoordinates = new GridPoint2(coordinates);
        if (newCoordinates.y >= WINDOW_HEIGHT) newCoordinates.y = WINDOW_HEIGHT -1;
        if (newCoordinates.y < 0) newCoordinates.y = 0;
        if (newCoordinates.x >= WINDOW_WIDTH) newCoordinates.x = WINDOW_WIDTH -1;
        if (newCoordinates.x < 0) newCoordinates.x = 0;
        return newCoordinates;
    }

    public void changeMovementProgress(float deltaTime) {
        movingAbility.setMovementProgress(continueProgress(movingAbility.getMovementProgress(), deltaTime, currentState.getMovementSpeed()));
    }

    public void changeShootingProgress(float deltaTime) {
        shootingProgress = continueProgress(shootingProgress, deltaTime, currentState.getShootSpeed());
    }

    public void shoot(Level level) {
        if (!currentState.getAbilityShoot()) { return; }
        if (!isEqual(shootingProgress, 1f)) { return; }
        GridPoint2 coordinates = Direction.add(Direction.getDirectionByRotation(position.rotation),
                position.coordinates);
        if (DynamicObject.isAbleMove(coordinates, level)) {
            level.addDynamicObject(new DynamicObjectBullet(coordinates,
                    position.rotation));
        }
        shootingProgress = 0f;
    }
}
