package com.burtsnyder.boxrift.ui.javafx.block;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.boxrift.actor.Boxriftle;
import javafx.scene.Group;

public class BoxriftleRenderer {
    public static Group render(Boxriftle shape, int blockSize) {
        Group group = new Group();
        for (Block block : shape.getBlocks()) {
            group.getChildren().add(BlockRenderer.render(block, blockSize));
        }
        return group;
    }
}
