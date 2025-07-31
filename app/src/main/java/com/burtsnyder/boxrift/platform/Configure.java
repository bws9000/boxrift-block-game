package com.burtsnyder.boxrift.platform;

import com.burtsnyder.boxrift.ui.javafx.view.JavaFXGameLoop;

public class Configure {
    public static void launch(String[] args) {
        new JavaFXGameLoop().launchJavaFX();//for now
    }
}
