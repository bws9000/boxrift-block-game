package com.burtsnyder.boxrift.ui.javafx.block;

import com.burtsnyder.blockengine.core.block.Block;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class BlockRenderer {
    public static Rectangle render(Block block, int blockSize) {
        Rectangle rect = new Rectangle(blockSize, blockSize);
        rect.setX(block.getPosition().x * blockSize);
        rect.setY(block.getPosition().y * blockSize);

        switch (block.getColor()) {
            case CYAN -> rect.setFill(Color.CYAN);
            case YELLOW -> rect.setFill(Color.YELLOW);
            case PURPLE -> rect.setFill(Color.PURPLE);
            case GREEN -> rect.setFill(Color.GREEN);
            case ORANGE -> rect.setFill(Color.ORANGE);
            case BLUE -> rect.setFill(Color.BLUE);
            case RED -> rect.setFill(Color.RED);
        }

        return rect;
    }
}
