package com.burtsnyder.boxrift.ui.javafx.block;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.boxrift.actor.Boxriftle;
import javafx.scene.Group;

public class BoxriftleRenderer {
    public static Group render(Boxriftle piece, int blockSize) {
        Group group = new Group();
        var o = piece.getOrigin();
        for (Block block : piece.getBlocks()) {

            int gx = o.x() + block.getPosition().x();
            int gy = o.y() + block.getPosition().y();
            //System.out.println("draw @" + gx + "," + gy);

            group.getChildren().add(
                    BlockRenderer.renderAt(block, blockSize, o.x(), o.y()) // origin + offset
            );
        }
        return group;
    }
}
