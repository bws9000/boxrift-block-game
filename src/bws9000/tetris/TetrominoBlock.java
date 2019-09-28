package bws9000.tetris;

import javafx.scene.shape.Rectangle;

/**
 * Tetris Test with JavaFX
 *
 * @author  Burt W Snyder
 * @version 0.1
 * @since   2019-09-21
 */
public class TetrominoBlock extends Rectangle {
    Rectangle getRectangle(int block_size){
        this.setWidth(block_size);
        this.setHeight(block_size);
        return this;
    }

}
