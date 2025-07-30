package com.burtsnyder.boxrift.core.block;

import com.burtsnyder.boxrift.core.board.Coord;

import java.util.ArrayList;
import java.util.List;

public class BoxriftleFactory {

    public static Boxriftle create(BlockSetType type) {
        Coord origin = new Coord(4, 0); //..
        List<Block> blocks = new ArrayList<>();

        switch (type) {
            case I -> {
                blocks.add(new Block(origin.add(-1, 0), type));
                blocks.add(new Block(origin, type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(2, 0), type));
            }
            case O -> {
                blocks.add(new Block(origin, type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(0, 1), type));
                blocks.add(new Block(origin.add(1, 1), type));
            }
            case T -> {
                blocks.add(new Block(origin.add(-1, 0), type));
                blocks.add(new Block(origin, type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(0, 1), type));
            }
            //add shape/type
            default -> throw new IllegalArgumentException("Unimplemented piece: " + type);
        }

        return new Boxriftle(type, blocks, origin, null);//no rotation right now...
    }
}
