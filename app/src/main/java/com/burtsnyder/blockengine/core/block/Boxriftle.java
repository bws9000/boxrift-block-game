package com.burtsnyder.blockengine.core.block;

import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.blockengine.core.types.Rotation;

import java.util.List;

public class Boxriftle {
    private final BlockSetType type;
    private List<Block> blocks;
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

    public Boxriftle move(int dx, int dy) {
        Coord newOrigin = origin.add(dx, dy);
        List<Block> movedBlocks = blocks.stream()
                .map(block -> block.move(dx, dy))
                .toList();
        return new Boxriftle(type, movedBlocks, newOrigin, rotation);
    }

    public Boxriftle rotateClockwise() {
        return this;
    }

    public Boxriftle rotateCounterClockwise() { return this; }

    public void setColor(BlockSetColor color) {
        this.blocks = blocks.stream()
                .map(block -> new Block(block.getPosition(), block.getType(), color))
                .toList();
    }

    public Boxriftle withColor(BlockSetColor color) {
        List<Block> recoloredBlocks = blocks.stream()
                .map(block -> new Block(block.getPosition(), block.getType(), color))
                .toList();
        return new Boxriftle(type, recoloredBlocks, origin, rotation);
    }

}
