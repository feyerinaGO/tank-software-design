package ru.mipt.bit.platformer.playobjects;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.game_data.TypeGameObjects;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.GLOBAL_ACCELERATION;
import static ru.mipt.bit.platformer.game_data.ConstantSettings.GLOBAL_MOVEMENT_SPEED;

public class DynamicObjectBullet extends DynamicObject{
    public DynamicObjectBullet(GridPoint2 initialCoordinates, float rotation) {

        super(initialCoordinates, rotation, GLOBAL_MOVEMENT_SPEED*GLOBAL_ACCELERATION,
                TypeGameObjects.BULLET);
//        movingAbility.movementProgress = 0f;
    }

    @Override
    public void move(Direction direction, Level level) {
        if (!isEqual(this.movingAbility.getMovementProgress(), 1f)) { return; }
        GridPoint2 newCoordinates = Direction.add(direction, this.position.coordinates);
        GridPoint2 newCorrectedCoordinates = correctWithBorders(newCoordinates);
        if ((newCorrectedCoordinates.x==newCoordinates.x) && (newCorrectedCoordinates.y==newCoordinates.y)){
            this.position.setNeedDecrease(true);
        }
        this.position.rotation = direction.getAngle();
        if (isNotCrash(newCoordinates, level)) {
            this.movingAbility.nextCoordinates.set(newCoordinates);
            this.movingAbility.setMovementProgress(0f);
        }
    }

    private boolean isNotCrash(GridPoint2 coordinates, Level level) {
        for (StaticObject obstacle : level.getStaticObstacles()) {
            if (obstacle.position.coordinates.equals(coordinates)) {
                this.position.decreaseHealthLevel();
                return false;
            }
        }
        for (DynamicObject dynamicObject : level.getDynamicObjects()) {
            if ((dynamicObject.position.coordinates.equals(coordinates)) ||
                    (dynamicObject.movingAbility.nextCoordinates.equals(coordinates))) {
                dynamicObject.position.decreaseHealthLevel();
                this.position.decreaseHealthLevel();
                return false;
            }
        }
        return true;
    }
}
