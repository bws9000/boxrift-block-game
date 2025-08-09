package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.core.rules.RuleContext;
import com.burtsnyder.blockengine.util.Coord;
import com.burtsnyder.boxrift.actor.Boxriftle;
import com.burtsnyder.boxrift.actor.BoxriftleFactory;
import com.burtsnyder.blockengine.core.block.BlockSetType;

import java.util.Random;

public class SpawnRule extends BaseRule {
    private final Random random = new Random();

    public SpawnRule(GameState state) { super(state); }

    @Override
    public int priority() {
        return -100; // spawn before movem/gravity
    }

    @Override
    public void apply(GameState state, RuleContext ctx) {
        if (state.getActivePiece() != null) return;

        var grid = state.getGrid();
        int spawnX = (grid.getWidth() / 2) - 1;
        int spawnY = 0;

        BlockSetType[] types = BlockSetType.values();
        BlockSetType type = types[random.nextInt(types.length)];
        Boxriftle piece = new BoxriftleFactory(type).createAt(new Coord(spawnX, spawnY));

        // ids
        piece.setId(state.generateNextPieceId());
        piece.setGroupId(state.generateNextGroupId());


        //todo: set a game-over flag or trigger a TopOutRule

        state.setActivePiece(piece);
    }
}

