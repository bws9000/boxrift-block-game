package com.burtsnyder.boxrift.ui.javafx.view;

import com.burtsnyder.blockengine.core.engine.GameLoop;
import com.burtsnyder.blockengine.core.engine.GameManager;
import com.burtsnyder.boxrift.rules.ColorCycleRule;
import com.burtsnyder.boxrift.rules.LineClearRule;
import com.burtsnyder.boxrift.ui.javafx.JavaFXRenderer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXGameLoop extends GameLoop {
    public void launchJavaFX() {
        Application.launch(JavaFXApp.class);
    }
    public Group getPieceLayer() { return pieceLayer; }

    public static class JavaFXApp extends Application {
        public static Stage primaryStageRef;

        @Override
        public void start(Stage primaryStage) {
            primaryStageRef = primaryStage;
            //manager handles state and rules
            //loop handles tick/updateView and rendering control
            JavaFXGameLoop loop = new JavaFXGameLoop();
            loop.initUI(primaryStage);
            GameManager manager = loop.getManager();
            //game specific rules
            manager.addRule(new LineClearRule(manager.getState()));
            manager.addRule(new ColorCycleRule(manager.getState()));//test
            loop.setRenderer(new JavaFXRenderer(loop.getPieceLayer(), 25));
            loop.start();
        }
    }

    private Group root;
    private Group pieceLayer;

    private void initUI(Stage stage) {
        root = new Group();
        pieceLayer = new Group();
        root.getChildren().add(pieceLayer);
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
                    updateView();
                    lastUpdate = now;
                }
            }
        }.start();
    }
}

