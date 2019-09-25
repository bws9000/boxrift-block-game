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

    private Rectangle rectangle;
    private int block_size = 25;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        primaryStage.setTitle("Tetris Test");
        primaryStage.setScene(new Scene(root, 400, 800));

        double[][] l_map = new Tetromino(block_size).getShape();
        LinkedList<Rectangle> l_shape = new LinkedList<>();
        for (int i = 0; i < l_map.length; i++) {
            rectangle = new TetrominoBlock().getRectangle(block_size);
            rectangle.setX(l_map[i][0]);
            rectangle.setY(l_map[i][1]);
            l_shape.add(rectangle);
        }

        for (int i = 0; i < l_shape.size(); i++) {
            root.getChildren().add(l_shape.get(i));
        }
        primaryStage.show();

        System.out.println(rectangle.getBoundsInLocal());

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
