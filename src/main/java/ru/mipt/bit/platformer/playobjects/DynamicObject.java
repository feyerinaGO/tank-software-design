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

    private boolean isAbleMove(GridPoint2 coordinates, Level level) {
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
        newCoordinates = checkBorders(newCoordinates);
        position.rotation = direction.getAngle();
        if (isAbleMove(newCoordinates, level)) {
            movingAbility.nextCoordinates.set(newCoordinates);
            movingAbility.movementProgress = 0f;
        }
    }

    public void takeChanges(float deltaTime) {
        movingAbility.changeMovementProgress(deltaTime);
        if (isEqual(movingAbility.movementProgress, 1f)) {
            position.coordinates.set(movingAbility.nextCoordinates);
        }
    }

    private GridPoint2 checkBorders(GridPoint2 coordinates) {
        if (coordinates.y >= WINDOW_HEIGHT) coordinates.y = WINDOW_HEIGHT -1;
        if (coordinates.y < 0) coordinates.y = 0;
        if (coordinates.x >= WINDOW_WIDTH) coordinates.x = WINDOW_WIDTH -1;
        if (coordinates.x < 0) coordinates.x = 0;
        return coordinates;
    }
}
