package com.burtsnyder.blockengine.core.engine;

import com.burtsnyder.blockengine.core.actor.Actor;
import com.burtsnyder.blockengine.core.board.Grid;
import com.burtsnyder.blockengine.core.input.InputAction;
import com.burtsnyder.blockengine.core.rules.interfaces.Rule;
import com.burtsnyder.blockengine.platform.interfaces.GameEngine;
import com.burtsnyder.boxrift.actor.Boxriftle;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements GameEngine {
    private final GameState state;
    private final List<Rule> rules = new ArrayList<>();

    public GameManager(int col, int row) {
        this.state = new GameState(col,row);
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void applyRules() {
        for (Rule rule : rules) {
            rule.apply(state);
        }
    }

    @Override
    public void tick() {
        applyRules();
    }

    public GameState getState() {
        return state;
    }

    public void applyInput(InputAction a) {
        switch (a) {
            case MOVE_LEFT  -> tryShift(-1, 0);
            case MOVE_RIGHT -> tryShift(+1, 0);
            case SOFT_DOWN  -> tryShift(0, +1);
        }
    }

    private void tryShift(int dx, int dy) {
        var p = state.getActivePiece();
        if (p == null) return;
        var moved = (Actor) p.move(dx, dy);
        if (canPlace(moved, state.getGrid())) {
            state.setActivePiece((Boxriftle)moved);
        }
    }

    private boolean canPlace(Actor actor, Grid grid) {
        var o = actor.getOrigin();
        for (var b : actor.getBlocks()) {
            var p = b.getPosition();
            int x = o.x() + p.x();
            int y = o.y() + p.y();
            if (!grid.inBounds(x, y)) return false;
            if (!grid.isEmpty(x, y)) return false;
        }
        return true;
    }
}