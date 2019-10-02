package bws9000.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 *
 * Java FX Rectangle object for Tetromino shape
 */
public class TetrominoBlock extends Rectangle {

    double BLOCK_SIZE = 25;
    private boolean center_node;
    private String in_shape = "";
    public int shape_index = 0;

    TetrominoBlock(String shape) {
        this.setWidth(BLOCK_SIZE);
        this.setHeight(BLOCK_SIZE);
        this.setIn_shape(shape);
    }

    public void setShapeIndex(int index) {
        this.shape_index = index;
    }

    public void setCenterNode(){
        this.center_node = true;
    }

    public boolean isCenter_node(){
        return this.center_node;
    }

    public void setIn_shape(String shape) {
        this.in_shape = shape;
    }

    public void unsetCenter(){
        this.center_node = false;
    }

    public void unsetCenterColor(){
        this.unsetCenter();
        if(!this.center_node){
            this.setFill(Color.BLACK);
        }
    }

}
