package com.burtsnyder.blockengine.core.engine;

import com.burtsnyder.blockengine.core.block.Boxriftle;

public class GameState {
    private Boxriftle activePiece;

    public GameState() {}

    public void setActivePiece(Boxriftle piece) {
        this.activePiece = piece;
    }

    public Boxriftle getActivePiece() {
        return activePiece;
    }
}
