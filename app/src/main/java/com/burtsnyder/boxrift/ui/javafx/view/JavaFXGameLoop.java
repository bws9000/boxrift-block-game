package com.burtsnyder.boxrift.ui.javafx.view;

import com.burtsnyder.blockengine.core.engine.GameLoop;
import com.burtsnyder.blockengine.core.engine.GameManager;
import com.burtsnyder.boxrift.rules.GravityRule;
import com.burtsnyder.boxrift.rules.SpawnRule;
import com.burtsnyder.boxrift.ui.javafx.JavaFXBoxriftleRenderer;
import com.burtsnyder.boxrift.ui.javafx.JavaFXGridRenderer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXGameLoop extends GameLoop {

    private static int staticBlockSize;
    private static int col;
    private static int row;

    public JavaFXGameLoop(int blockSize, int col, int row) {
        super(blockSize, col, row);
        JavaFXGameLoop.staticBlockSize = blockSize;
        JavaFXGameLoop.col = col;
        JavaFXGameLoop.row = row;
    }

    public void launchJavaFX() {
        Application.launch(JavaFXApp.class);
    }

    public Group getPieceLayer() {  return pieceLayer; }
    private int getBoxSize() { return staticBlockSize; }

    public static class JavaFXApp extends Application {
        public static Stage primaryStageRef;

        @Override
        public void start(Stage primaryStage) {
            primaryStageRef = primaryStage;
            JavaFXGameLoop loop = new JavaFXGameLoop(staticBlockSize,col,row);
            loop.initUI(primaryStage);
            GameManager manager = loop.getManager();

            // Game
            manager.addRule(new GravityRule(manager.getState()));
            manager.addRule(new SpawnRule(manager.getState()));
            ///////

            loop.setRenderer(new JavaFXBoxriftleRenderer(loop.getPieceLayer(), loop.getBoxSize()));
            loop.start();
        }
    }

    private Group pieceLayer;

    private void initUI(Stage stage) {
        Group root = new Group();
        Group gridLayer = new Group();
        pieceLayer = new Group();

        root.getChildren().addAll(gridLayer, pieceLayer);

        JavaFXGridRenderer.render(manager.getState().getGrid(), gridLayer, staticBlockSize);

        Scene scene = new Scene(root,
                row * staticBlockSize,
                col * staticBlockSize);

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

