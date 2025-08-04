package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockMetadata;
import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.boxrift.actor.Boxriftle;
import com.burtsnyder.boxrift.actor.BoxriftleFactory;
import com.burtsnyder.blockengine.core.block.BlockSetType;

import java.util.Random;

public class SpawnRule extends BaseRule {
    private final Random random = new Random();

    public SpawnRule(GameState state) {
        super(state);
    }

    @Override
    public void apply(GameState state) {
        if (state.getActivePiece() == null) {
            BlockSetType[] types = BlockSetType.values();
            BlockSetType randomType = types[random.nextInt(types.length)];

            Boxriftle newPiece = new BoxriftleFactory(randomType).create();

            long pieceId = -1;
            long groupId = state.generateNextGroupId();

            for (Block block : newPiece.getBlocks()) {
                Coord pos = block.getPosition();
                state.getGrid().setBlockAt(pos, block);

                pieceId = state.generateNextPieceId();
                newPiece.setId(pieceId);
                newPiece.setGroupId(groupId);

                state.getGrid().getCell(pos).setMetadata(
                        new BlockMetadata(
                                pieceId,
                                groupId,
                                false,  // Locked
                                true  //just spawned
                        )
                );
            }

            state.setActivePiece(newPiece);

            for (Block block : newPiece.getBlocks()) {
                Coord pos = block.getPosition();
                BlockMetadata meta = state.getGrid().getCell(pos).getMetadata();
            }

        }

    }
}

