package com.burtsnyder.boxrift;

import com.burtsnyder.boxrift.config.BlockConfig;
import com.burtsnyder.boxrift.ui.javafx.JavaFXGameLoop;

public class Game {
    public static void main(String[] args) {
        new JavaFXGameLoop(
                BlockConfig.BLOCK_SIZE,
                BlockConfig.GRID_ROWS,
                BlockConfig.GRID_COLUMNS).launchJavaFX();
    }
}
