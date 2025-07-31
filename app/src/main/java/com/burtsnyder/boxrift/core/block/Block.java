package com.burtsnyder.boxrift.core.block;

import com.burtsnyder.boxrift.core.board.Coord;

public class Block {
    private final Coord position;
    private final BlockSetType type; //shape/type

    public Block(Coord position, BlockSetType type) {
        this.position = position;
        this.type = type;
    }

    public Coord getPosition() {
        return position;
    }

    public BlockSetType getType() {
        return type;
    }

    public Block move(int dx, int dy) {
        return new Block(position.add(dx, dy), type);
    }

    public Block withPosition(Coord newPosition) {
        return new Block(newPosition, type);
    }
}
