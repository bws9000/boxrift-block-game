package com.burtsnyder.boxrift.core.block;

import com.burtsnyder.boxrift.core.board.Coord;
import com.burtsnyder.boxrift.core.types.Rotation;

import java.util.List;

public class Boxriftle {
    private final BlockSetType type;
    private final List<Block> blocks;
    private final Coord origin;
    private final Rotation rotation;

    public Boxriftle(BlockSetType type, List<Block> blocks, Coord origin, Rotation rotation) {
        this.type = type;
        this.blocks = blocks;
        this.origin = origin;
        this.rotation = rotation;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Coord getOrigin() {
        return origin;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public BlockSetType getType() {
        return type;
    }

    //for movement maybe...
    public Boxriftle move(int dx, int dy) {
        Coord newOrigin = origin.add(dx, dy);
        List<Block> movedBlocks = blocks.stream()
                .map(block -> block.move(dx, dy))
                .toList();
        return new Boxriftle(type, movedBlocks, newOrigin, rotation);
    }

    public Boxriftle rotateClockwise() {
        //rotation strategy...
        return this; //schtub
    }

    public Boxriftle rotateCounterClockwise() {
        return this;//
    }
}
