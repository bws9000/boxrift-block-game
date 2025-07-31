package com.burtsnyder.boxrift.core.board;

import com.burtsnyder.boxrift.core.block.Block;
import com.burtsnyder.boxrift.core.block.Boxriftle;

import java.util.HashSet;
import java.util.Set;

public class Grid {

    private final int width;
    private final int height;
    private final Set<Coord> occupied;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.occupied = new HashSet<>();
    }

    public boolean canPlace(Boxriftle piece) {
        for (Block block : piece.getBlocks()) {
            Coord pos = block.getPosition();
            if (pos.x < 0 || pos.x >= width || pos.y < 0 || pos.y >= height) {
                return false;
            }
            if (occupied.contains(pos)) {
                return false;
            }
        }
        return true;
    }

    public void lock(Boxriftle piece) {
        for (Block block : piece.getBlocks()) {
            occupied.add(block.getPosition());
        }
    }

    public void clearFullLines() {
        //line clearing..
    }

    public Set<Coord> getOccupiedCoords() {
        return new HashSet<>(occupied);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
