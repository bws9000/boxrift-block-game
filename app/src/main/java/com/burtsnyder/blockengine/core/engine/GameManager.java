package com.burtsnyder.blockengine.core.engine;

import com.burtsnyder.blockengine.core.rules.interfaces.Rule;
import com.burtsnyder.blockengine.platform.interfaces.GameEngine;
import java.util.ArrayList;
import java.util.List;

public class GameManager implements GameEngine {
    private final GameState state;
    private final List<Rule> rules = new ArrayList<>();

    public GameManager(int row, int col) {
        this.state = new GameState(row,col);
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
}