package bws9000.tetris;

/**
 * Tetris Test with JavaFX
 *
 * @author  Burt W Snyder
 * @version 0.1
 * @since   2019-09-21
 */
class Tetromino {

    private double[][] shape;
    private int block;


    public Tetromino(int block) {

        int[] init_L = {
                1, 0, 0, 0,
                1, 0, 0, 0,
                1, 0, 0, 0,
                1, 1, 0, 0
        };

        this.block = block;
        this.shape = Shape(init_L);
    }

    /**
     *
     * @return shape
     */
    public double[][] getShape(){
        return this.shape;
    }

    /**
     * Takes an array that describes a shape
     * returns coordinates of shape on game board
     * @param shape_map
     * @return shape
     */
    private double[][] Shape(int[] shape_map) {
        int start_x = 0;
        int start_y = 0;
        double[][] cooridinates = new double[24][2];
        int x = start_x;
        int y = start_y;
        double[][] shape = new double[16][2];
        for (int i = 0; i < shape_map.length; i++) {
            y += (i != 0 && i % 4 == 0) ? this.block : 0;
            x = (i != 0 && i % 4 == 0) ? 0 : x;
            cooridinates[i][0] = x;
            cooridinates[i][1] = y;
            x += this.block;
            if (shape_map[i] == 1) {
                shape[i] = cooridinates[i];
            }
        }
        return shape;
    }
}