package com.burtsnyder.boxrift.ui.javafx;

import com.burtsnyder.blockengine.platform.interfaces.GameRenderer;
import com.burtsnyder.blockengine.core.engine.GameState;
import com.burtsnyder.boxrift.ui.javafx.block.BoxriftleRenderer;
import javafx.scene.Group;

public record JavaFXBoxriftleRenderer(Group pieceLayer, int blockSize) implements GameRenderer {

    public JavaFXBoxriftleRenderer() {
        this(null, 0);
    }

    @Override
    public void render(GameState state) {
        pieceLayer.getChildren().clear();
        var piece = state.getActivePiece();
        if (piece != null) {
            pieceLayer.getChildren().add(
                    BoxriftleRenderer.render(piece, blockSize)
            );
        }
    }
}
