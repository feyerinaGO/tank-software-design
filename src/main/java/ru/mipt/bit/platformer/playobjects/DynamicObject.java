package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_HEIGHT;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.WINDOW_WIDTH;

public class DynamicObject {
    public Position position;
    public MovingAbility movingAbility;

    public DynamicObject(GridPoint2 initialCoordinates, float rotation, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, rotation, type);
        this.movingAbility = new MovingAbility(new GridPoint2(this.position.coordinates));
    }

    public DynamicObject(GridPoint2 initialCoordinates, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, type);
        this.movingAbility = new MovingAbility(new GridPoint2(this.position.coordinates));
    }

    public DynamicObject(GridPoint2 initialCoordinates, float rotation, float movementSpeed, TypeGameObjects type) {
        this.position = new Position(initialCoordinates, rotation, type);
        this.movingAbility = new MovingAbility(movementSpeed, new GridPoint2(this.position.coordinates));
    }

    public static boolean isAbleMove(GridPoint2 coordinates, Level level) {
        for (StateObject obstacle : level.staticObstacles) {
            if (obstacle.position.coordinates.equals(coordinates)) {
                return false;
            }
        }
        for (DynamicObject dynamicObject : level.dynamicObjects) {
            if ((dynamicObject.position.coordinates.equals(coordinates)) ||
                    (dynamicObject.movingAbility.nextCoordinates.equals(coordinates))) {
                return false;
            }
        }
        return true;
    }

    public void move(Direction direction, Level level) {
        if (!isEqual(movingAbility.movementProgress, 1f)) { return; }
        GridPoint2 newCoordinates = Direction.add(direction, position.coordinates);
        GridPoint2 newCorrectedCoordinates = correctWithBorders(newCoordinates);
        position.rotation = direction.getAngle();
        if (isAbleMove(newCorrectedCoordinates, level)) {
            movingAbility.nextCoordinates.set(newCorrectedCoordinates);
            movingAbility.movementProgress = 0f;
        }
    }

    public void takeChanges(float deltaTime) {
        movingAbility.changeMovementProgress(deltaTime);
        if (isEqual(movingAbility.movementProgress, 1f)) {
            position.coordinates.set(movingAbility.nextCoordinates);
            if (position.isNeedDecrease()) {
                position.decreaseHealthLevel();
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
}
