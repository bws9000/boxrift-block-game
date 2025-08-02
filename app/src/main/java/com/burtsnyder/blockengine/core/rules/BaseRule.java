package com.burtsnyder.blockengine.core.rules;

import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.interfaces.Rule;

public abstract class BaseRule implements Rule {
    protected final GameState state;

    public BaseRule(GameState state) {
        this.state = state;
    }
    @Override
    public abstract void apply(GameState state);
}

