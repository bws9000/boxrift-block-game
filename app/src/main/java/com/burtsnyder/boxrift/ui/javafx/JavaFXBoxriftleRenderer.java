package com.burtsnyder.boxrift.ui.javafx;

import com.burtsnyder.boxrift.actor.Boxriftle;
import com.burtsnyder.blockengine.platform.interfaces.GameRenderer;
import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.boxrift.ui.javafx.block.BoxriftleRenderer;
import javafx.scene.Group;

public class JavaFXBoxriftleRenderer implements GameRenderer {
    private final Group pieceLayer;
    private final int blockSize;

    public JavaFXBoxriftleRenderer(Group pieceLayer, int blockSize) {
        this.pieceLayer = pieceLayer;
        this.blockSize = blockSize;
    }

    @Override
    public void render(GameState state) {
        pieceLayer.getChildren().clear();
        Boxriftle piece = state.getActivePiece();
        if (piece != null) {
            pieceLayer.getChildren().add(BoxriftleRenderer.render(piece, blockSize));
        }
    }
}
