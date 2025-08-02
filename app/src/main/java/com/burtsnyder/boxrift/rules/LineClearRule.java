package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.core.engine.GameState;

public class LineClearRule extends BaseRule {

    public LineClearRule(GameState state) {
        super(state);
    }

    @Override
    public void apply(GameState state) {
        //todo:add logic to clear etc etc ..
        System.out.println("applying line clear rule...");
        // int[][] board =  state.getBoard();
        // if (isLineFull(board)) { clearLine(board);}
    }
}
