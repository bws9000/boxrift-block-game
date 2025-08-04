package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockMetadata;
import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.blockengine.core.board.Cell;

public class GravityRule extends BaseRule {

    public GravityRule(GameState state) {
        super(state);
    }

    @Override
    public void apply(GameState state) {
        if (state.getActivePiece() == null) {
            // no active piece yet just return now..
            return;
        }

        var piece = state.getActivePiece();
        boolean canMoveDown = true;

        for (Block block : piece.getBlocks()) {
            Coord below = block.getPosition().down();

            if (below.y < 0 || below.y >= state.getGrid().getHeight() ||
                    below.x < 0 || below.x >= state.getGrid().getWidth()) {
                canMoveDown = false;
                break;
            }

            Cell cellBelow = state.getGrid().getCell(below);
            if (!cellBelow.isEmpty() && cellBelow.getMetadata().isLocked()) {
                canMoveDown = false;
                break;
            }

        }

        if (canMoveDown) {
            state.setActivePiece(piece.move(0, 1));
        } else {

            for (Block block : piece.getBlocks()) {
                Coord pos = block.getPosition();
                Cell cell = state.getGrid().getCell(pos);

                var oldMeta = cell.getMetadata();
                if (oldMeta == null) {
                    // Hits bottom... next up - todo: stick to bottom add real logging
                    oldMeta = new BlockMetadata(0, 0, false, false);// Falllbak
                }
                cell.setMetadata(oldMeta.copyWith(
                        null,
                        null,
                        true,   // locked
                        false   // justSpawned
                ));

            }

            state.setActivePiece(null);
        }
    }
}
