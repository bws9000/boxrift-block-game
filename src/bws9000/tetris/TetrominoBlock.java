package bws9000.tetris;

import javafx.scene.shape.Rectangle;

/**
 * Tetris Test with JavaFX
 *
 * @author  Burt W Snyder
 * @version 0.1
 * @since   2019-09-21
 */
public class TetrominoBlock {

    Rectangle getRectangle(int block_size){
        Rectangle r = new Rectangle();
        r.setWidth(block_size);
        r.setHeight(block_size);
        return r;
    }

}
