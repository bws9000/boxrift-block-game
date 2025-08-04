package com.burtsnyder.boxrift.actor;

import com.burtsnyder.blockengine.core.actor.interfaces.ActorFactory;
import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockSetType;

import java.util.ArrayList;
import java.util.List;

public class BoxriftleFactory implements ActorFactory<Boxriftle> {
    private final BlockSetType type;

    public BoxriftleFactory(BlockSetType type) {
        this.type = type;
    }

    @Override
    public Boxriftle create() {
        Coord origin = new Coord(7, 0);//tmp pseudo center x
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
            case S -> {
                blocks.add(new Block(origin.add(0, 0), type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(-1, 1), type));
                blocks.add(new Block(origin.add(0, 1), type));
            }
            case Z -> {
                blocks.add(new Block(origin.add(-1, 0), type));
                blocks.add(new Block(origin.add(0, 0), type));
                blocks.add(new Block(origin.add(0, 1), type));
                blocks.add(new Block(origin.add(1, 1), type));
            }
            case J -> {
                blocks.add(new Block(origin.add(-1, 0), type));
                blocks.add(new Block(origin, type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(1, 1), type));
            }
            case L -> {
                blocks.add(new Block(origin.add(-1, 0), type));
                blocks.add(new Block(origin, type));
                blocks.add(new Block(origin.add(1, 0), type));
                blocks.add(new Block(origin.add(-1, 1), type));
            }
            default -> throw new IllegalArgumentException("Unimplemented piece: " + type);
        }

        return new Boxriftle(type, blocks, origin, null);
    }

    @Override
    public Boxriftle createAt(Coord origin) {
        return null;
    }
}

