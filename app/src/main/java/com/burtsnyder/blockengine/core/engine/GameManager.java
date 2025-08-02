package com.burtsnyder.blockengine.core.engine;

import com.burtsnyder.blockengine.core.block.BlockSetType;
import com.burtsnyder.blockengine.core.block.Boxriftle;
import com.burtsnyder.blockengine.core.block.BoxriftleFactory;
import com.burtsnyder.blockengine.core.rules.interfaces.Rule;
import com.burtsnyder.blockengine.platform.interfaces.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements GameEngine {
    private final GameState state;
    private final List<Rule> rules = new ArrayList<>();

    public GameManager() {
        this.state = new GameState();
        spawnSingleTestPiece();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void applyRules() {
        for (Rule rule : rules) {
            rule.apply(state);
        }
    }


    public void spawnSingleTestPiece() {
        Boxriftle testPiece = BoxriftleFactory.create(BlockSetType.S);
        state.setActivePiece(testPiece);
    }

    @Override
    public void tick() {
        Boxriftle falling = state.getActivePiece();
        if (falling != null) {
            Boxriftle moved = falling.move(0, 1);
            state.setActivePiece(moved);
            System.out.println("tick:  piece moved to y=" + moved.getOrigin().y);
        } else {
            System.out.println("tick: no active piece");
        }
        applyRules();
    }

    public GameState getState() {
        return state;
    }
}