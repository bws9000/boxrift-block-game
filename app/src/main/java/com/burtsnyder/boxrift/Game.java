package com.burtsnyder.boxrift;

import com.burtsnyder.boxrift.config.BlockConfig;
import com.burtsnyder.boxrift.ui.javafx.view.JavaFXGameLoop;

public class Game {
    public static void main(String[] args) {
        new JavaFXGameLoop(
                BlockConfig.BLOCK_SIZE,
                BlockConfig.GRID_COLUMNS,
                BlockConfig.GRID_ROWS,
                BlockConfig.GAME_NAME
                ).launchJavaFX();
    }
}
