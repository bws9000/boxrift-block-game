package com.burtsnyder.boxrift.ui.libgdx.view;

import com.burtsnyder.blockengine.core.engine.GameLoop;
import com.burtsnyder.blockengine.core.input.InputBus;

public class LibGDXGameLoop extends GameLoop {

    public LibGDXGameLoop(int blockSize, int col, int row, InputBus inputBus) {
        super(blockSize, col, row, inputBus);
    }

    @Override
    public void start() {}
}
