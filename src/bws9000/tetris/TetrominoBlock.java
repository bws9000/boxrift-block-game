package bws9000.tetris;

import javafx.scene.shape.Rectangle;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 */
public class TetrominoBlock extends Rectangle {

    double BLOCK_SIZE = 25;
    public boolean center_node = false;
    private String in_shape = "";
    private int shape_index = 0;

    TetrominoBlock(String shape) {
        this.setWidth(BLOCK_SIZE);
        this.setHeight(BLOCK_SIZE);
        this.setIn_shape(shape);
    }

    public void setShapeIndex(int index) {
        this.shape_index = index;
        this.setCenter_node();
    }

    public void setIn_shape(String shape) {
        this.in_shape = shape;
    }

    private void setCenter_node() {
        if (this.shape_index == 1 && !this.in_shape.equals("S")) {
            this.center_node = true;
        }
        if (this.in_shape.equals("S") && this.shape_index == 2) {
            this.center_node = true;
        }
    }

}
