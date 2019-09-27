package bws9000.tetris;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * Tetris Test with JavaFX
 *
 * @author  Burt W Snyder
 * @version 0.1
 * @since   2019-09-21
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        primaryStage.setTitle("Tetris Test");
        primaryStage.setScene(new Scene(root, 400, 800));

        LinkedList<Rectangle> tetromino = new Tetromino("S").getShape();
        for (int i = 0; i < tetromino.size();i++) {
            root.getChildren().add(tetromino.get(i));
        }
        primaryStage.show();

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                //
            }

        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}