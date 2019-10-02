package bws9000.tetris;

import java.util.LinkedList;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 *
 * linkList of center coordinates for tetromino shapes
 */
class GameBoard {
    private int w;
    private int h;
    private int vertical_nodes;
    private int horizontal_nodes;
    private double x_coor;
    private double y_coor;
    private double BLOCK_SIZE;
    private LinkedList<double[][]> center = new LinkedList<>();

    public GameBoard() {
        this.BLOCK_SIZE = 25;
        this.w = 400;
        this.h = 800;
        this.vertical_nodes = (int) (this.w - (this.BLOCK_SIZE * 2)) / (int) this.BLOCK_SIZE;
        this.horizontal_nodes = (int) (this.h - (this.BLOCK_SIZE * 2)) / (int) this.BLOCK_SIZE;
        setCenterList();
    }

    /**
     * create a linkList of the center coordinates of the board
     *
     */
    public void setCenterList() {
        double center_board[][][] = new double[this.vertical_nodes *
                this.horizontal_nodes][this.vertical_nodes][this.horizontal_nodes];
        this.x_coor = 0.0;
        this.y_coor = 0.0;

        for (int i = 0; i < this.vertical_nodes * this.horizontal_nodes; i++) {
            if (i % this.vertical_nodes == 0 && i != 0) {
                this.y_coor += this.BLOCK_SIZE;
                this.x_coor = 0.0;
            }

            if (this.x_coor != 0 && this.y_coor != 0) {
                double[][] c = new double[1][2];
                c[0][0] = this.x_coor;
                c[0][1] = this.y_coor;
                center_board[i] = c;
            }
            this.x_coor += this.BLOCK_SIZE;
        }

        for (int i = 0; i < center_board.length; i++) {
            if (center_board[i][0][0] != 0) {
                this.center.add(center_board[i]);
            }
        }
    }

    /**
     *
     * @return center coordinates
     */
    public LinkedList<double[][]> getCenterList(){
        return this.center;
    }
}
