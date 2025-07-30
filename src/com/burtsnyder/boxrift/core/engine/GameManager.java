package com.burtsnyder.boxrift.core.engine;

import com.burtsnyder.boxrift.core.block.BlockSetType;
import com.burtsnyder.boxrift.core.block.Boxriftle;
import com.burtsnyder.boxrift.core.block.BoxriftleFactory;
import com.burtsnyder.boxrift.core.board.Grid;
import com.burtsnyder.boxrift.core.types.Direction;
import com.burtsnyder.boxrift.core.types.Rotation;

import java.util.Optional;
import java.util.Random;

public class GameManager implements GameLoopEngine {

    private final Grid grid;
    private Boxriftle activeBoxriftle;
    private final Random random = new Random();

    public GameManager(int width, int height) {
        this.grid = new Grid(width, height);
        spawnNewBoxriftle();
    }

    @Override
    public void tick() {
        //move one
        if (canMove(Direction.DOWN)) {
            move(Direction.DOWN);
        } else {
            // lock piece in grid, clear/spawn..
            grid.lock(activeBoxriftle);
            grid.clearFullLines();
            spawnNewBoxriftle();
        }
    }

    public void move(Direction dir) {
        if (!dir.isEnabled()) return;

        var moved = switch (dir) {
            case LEFT -> activeBoxriftle.move(-1, 0);
            case RIGHT -> activeBoxriftle.move(1, 0);
            case DOWN -> activeBoxriftle.move(0, 1);
            case UP -> activeBoxriftle;
        };

        if (grid.canPlace(moved)) {
            activeBoxriftle = moved;
        }
    }

    public void rotate(Rotation rotation) {
        var rotated = switch (rotation) {
            case CLOCKWISE -> activeBoxriftle.rotateClockwise();
            case COUNTERCLOCKWISE -> activeBoxriftle.rotateCounterClockwise();
            default -> activeBoxriftle; // none
        };

        if (grid.canPlace(rotated)) {
            activeBoxriftle = rotated;
        }
    }

    public Boxriftle getActiveBoxriftle() {
        return activeBoxriftle;
    }

    public Grid getGrid() {
        return grid;
    }

    private void spawnNewBoxriftle() {
        BlockSetType type = BlockSetType.values()[random.nextInt(BlockSetType.values().length)];
        this.activeBoxriftle = BoxriftleFactory.create(type);
    }

    private boolean canMove(Direction dir) {
        var test = switch (dir) {
            case LEFT -> activeBoxriftle.move(-1, 0);
            case RIGHT -> activeBoxriftle.move(1, 0);
            case DOWN -> activeBoxriftle.move(0, 1);
            case UP -> null;
        };
        return grid.canPlace(test);
    }
}
