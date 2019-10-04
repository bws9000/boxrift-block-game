package bws9000.tetris;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 *
 * Tetris game starter test
 */
public class Main extends Application {

    private Group root;
    public double BLOCK_SIZE = 25;
    private int GRID_HEIGHT = 800;
    private int GRID_WIDTH = 400;
    private Tetromino tetromino;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new Group();
        primaryStage = new Stage();
        primaryStage.setTitle("Tetris Test");
        primaryStage.setScene(new Scene(root, 400, 800));
        primaryStage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    tetromino.rotate();
                    break;
                case LEFT:
                    tetromino.moveLeft();
                    tetromino.center_position--;
                    break;
                case RIGHT:
                    tetromino.moveRight();
                    tetromino.center_position++;
                    break;
            }
        });
        addTetronimo("Z");
        primaryStage.show();

        new AnimationTimer() {

            private long update_timer = 0;
            @Override
            public void handle(long now) {
                if (now - update_timer >= 600_000_000) {
                    tetromino.descend();
                    tetromino.center_position += 13;
                    update_timer = now ;
                }
            }

        }.start();
    }

    private void addTetronimo(String shape) {
        this.tetromino = new Tetromino(shape);
        root.getChildren().addAll(tetromino.getShape());
    }

    public static void main(String[] args) {
        launch(args);
    }

}