package bws9000.tetris;

import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

import static javafx.application.Platform.exit;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 */
class Tetromino {

    private Rectangle rectangle;
    private int block_size = 25;
    private int shape_grid_size = 9;
    private int shape_size = 4;
    private int shape_coordinates = 2;
    private int grid_start_x = 0;
    private int grid_start_y = 0;
    LinkedList<Rectangle> shape;

    int[] initJ = {
            0, 1, 0,
            0, 1, 0,
            1, 1, 0
    };

    int[] initS = {
            0, 1, 0,
            1, 1, 0,
            1, 0, 0
    };


    public Tetromino(String shape) {
        switch (shape) {
            case "J":
                initShape(initJ);
                break;
            case "S":
                initShape(initS);
                break;
            default:
                System.out.println("error: no shape found");
                exit();
        }
    }

    private void initShape(int[] coordinates) {
        double[][] shape_coordinates = this.mapShape(coordinates);
        this.shape = new LinkedList<>();
        for (int i = 0; i < this.shape_size; i++) {
            this.rectangle = new TetrominoBlock().getRectangle(block_size);
            this.rectangle.setX(shape_coordinates[i][0]);
            this.rectangle.setY(shape_coordinates[i][1]);
            this.shape.add(rectangle);
        }
    }

    /**
     * @return shape
     */

    public LinkedList<Rectangle> getShape() {
        return this.shape;
    }

    /**
     * Takes an array that describes a shape
     * returns coordinates of shape on game board
     *
     * @param shape_map
     * @return shape
     */

    private double[][] mapShape(int[] shape_map) {
        double[][] coordinates = new double[shape_grid_size][2];
        double[][] shape_c = new double[shape_grid_size][2];
        int x = this.grid_start_x;
        int y = this.grid_start_y;
        int shape_index=0;
        for (int i = 0; i < shape_grid_size; i++) {
            y += (i != 0 && i % 3 == 0) ? this.block_size : 0;
            x = (i % 3 == 0) ? 0 : (x += this.block_size);
            coordinates[i][0] = x;
            coordinates[i][1] = y;
            if(shape_map[i] == 1){
                shape_c[shape_index] = coordinates[i];
                shape_index++;
            }
        }
        return shape_c;
    }
}