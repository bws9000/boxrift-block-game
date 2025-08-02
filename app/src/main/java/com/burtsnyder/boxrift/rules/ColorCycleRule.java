package com.burtsnyder.boxrift.rules;

import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.blockengine.core.rules.BaseRule;
import com.burtsnyder.blockengine.core.block.Boxriftle;
import com.burtsnyder.blockengine.core.block.BlockSetColor;

public class ColorCycleRule extends BaseRule {
    private int colorIndex = 0;
    private static final BlockSetColor[] COLORS = BlockSetColor.values();

    public ColorCycleRule(GameState state) {
        super(state);
    }

    @Override
    public void apply(GameState state) {
        Boxriftle piece = state.getActivePiece();
        if (piece == null) return;

        // Cycle to the next color
        BlockSetColor nextColor = COLORS[colorIndex];
        Boxriftle recolored = piece.withColor(nextColor);
        state.setActivePiece(recolored);
        //piece.setColor(nextColor);
        System.out.println("ColorCycleRule: Changed color to " + nextColor);

        // Update index for next tick
        colorIndex = (colorIndex + 1) % COLORS.length;
    }
}
