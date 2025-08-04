package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.util.Coord;

// Gravity rule test..
public class GravityRule extends BaseRule {

    public GravityRule(GameState state) {
        super(state);
    }

    @Override
    public void apply(GameState state) {
        if (state.getActivePiece() != null) {
            System.out.println("Gravity Rule: active piece detected");
            for (Block block : state.getActivePiece().getBlocks()) {
                Coord pos = block.getPosition();
                var cell = state.getGrid().getCell(pos);
                var meta = cell.getMetadata();
                System.out.printf("block a %s -> %s\n", pos, meta);
            }
        } else {
            System.out.println("Gravity Rule: no active piece");
        }
    }
}
