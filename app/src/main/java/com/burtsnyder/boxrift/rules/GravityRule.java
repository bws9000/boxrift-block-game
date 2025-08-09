package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;

public class GravityRule extends BaseRule {
    public GravityRule(GameState state) { super(state); }

    @Override
    public void apply(GameState state) {
        var piece = state.getActivePiece();
        if (piece == null) return;
        state.setActivePiece(piece.move(0, 1));
    }
}
