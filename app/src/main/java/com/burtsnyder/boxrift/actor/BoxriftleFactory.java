package com.burtsnyder.boxrift.actor;

import com.burtsnyder.blockengine.core.actor.interfaces.ActorFactory;
import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockSetType;

import java.util.ArrayList;
import java.util.List;

public final class BoxriftleFactory {
    private final BlockSetType type;

    public BoxriftleFactory(BlockSetType type) { this.type = type; }

    private List<Block> localBlocksFor(BlockSetType t) {
        switch (t) {
            case I: return List.of(
                    new Block(new Coord(-1, 0), t),
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 1, 0), t),
                    new Block(new Coord( 2, 0), t)
            );
            case O: return List.of(
                    new Block(new Coord(0, 0), t),
                    new Block(new Coord(1, 0), t),
                    new Block(new Coord(0, 1), t),
                    new Block(new Coord(1, 1), t)
            );
            case T: return List.of(
                    new Block(new Coord(-1, 0), t),
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 1, 0), t),
                    new Block(new Coord( 0, 1), t)
            );
            case J: return List.of(
                    new Block(new Coord(-1, 0), t),
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 1, 0), t),
                    new Block(new Coord(-1, 1), t)
            );
            case L: return List.of(
                    new Block(new Coord(-1, 0), t),
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 1, 0), t),
                    new Block(new Coord( 1, 1), t)
            );
            case S: return List.of(
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 1, 0), t),
                    new Block(new Coord(-1, 1), t),
                    new Block(new Coord( 0, 1), t)
            );
            case Z: return List.of(
                    new Block(new Coord(-1, 0), t),
                    new Block(new Coord( 0, 0), t),
                    new Block(new Coord( 0, 1), t),
                    new Block(new Coord( 1, 1), t)
            );
            default:
                throw new IllegalArgumentException("Unhandled BlockSetType: " + t);
        }
    }

    public Boxriftle createAt(Coord origin) {
        var blocks = localBlocksFor(type);
        return new Boxriftle(type, blocks, origin,  null);
    }

//    public Boxriftle create() {
//        return createAt(new Coord(0, 0));
//    }
}

