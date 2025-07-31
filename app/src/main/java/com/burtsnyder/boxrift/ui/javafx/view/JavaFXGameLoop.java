package com.burtsnyder.boxrift.ui.javafx.view;

import com.burtsnyder.boxrift.core.engine.GameLoop;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXGameLoop extends GameLoop {
    public void launchJavaFX() {
        Application.launch(JavaFXApp.class);
    }

    public static class JavaFXApp extends Application {
        public static Stage primaryStageRef;

        @Override
        public void start(Stage primaryStage) {
            primaryStageRef = primaryStage;
            JavaFXGameLoop loop = new JavaFXGameLoop();
            loop.initUI(primaryStage);
            loop.start();
        }
    }

    private Group root;

    private void initUI(Stage stage) {
        root = new Group();
        Scene scene = new Scene(root, 400, 800);
        stage.setScene(scene);
        stage.setTitle("Boxrift");
        stage.show();
    }

    @Override
    public void start() {
        new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 600_000_000) {
                    manager.tick();
                    lastUpdate = now;
                }
            }
        }.start();
    }
}

