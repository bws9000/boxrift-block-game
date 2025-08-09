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

    public SpawnRule(GameState state) { super(state); }

    @Override
    public void apply(GameState state) {
        if (state.getActivePiece() != null) return;

        var grid = state.getGrid();
        int spawnX = (grid.getWidth() / 2) - 1;
        int spawnY = 0;

        BlockSetType[] types = BlockSetType.values();
        BlockSetType type = types[random.nextInt(types.length)];
        Boxriftle piece = new BoxriftleFactory(type).createAt(new Coord(spawnX, spawnY));

        long pieceId = state.generateNextPieceId();
        long groupId = state.generateNextGroupId();
        piece.setId(pieceId);
        piece.setGroupId(groupId);

        state.setActivePiece(piece);
    }
}

