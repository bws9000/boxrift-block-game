package com.burtsnyder.blockengine.core.block;

import com.burtsnyder.blockengine.util.Coord;

public class Block {
    private final Coord position;
    private final BlockSetType type;
    private final BlockSetColor color;

    public Block(Coord position, BlockSetType type) {
        this(position, type, BlockStyle.getColorForType(type));
    }

    public Block(Coord position, BlockSetType type, BlockSetColor color) {
        this.position = position;
        this.type = type;
        this.color = color;
    }

    public BlockSetColor getColor() {
        return color;
    }

    public Coord getPosition() {
        return position;
    }

    public BlockSetType getType() {
        return type;
    }

    public Block move(int dx, int dy) {
        return new Block(position.add(dx, dy), type, color);
    }

    public Block withPosition(Coord newPosition) {
        return new Block(newPosition, type);
    }

}
