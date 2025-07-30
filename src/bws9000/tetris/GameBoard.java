package bws9000.tetris;

import java.util.ArrayList;
import java.util.List;

class GameBoard {
    private final int width;
    private final int height;
    private final double BLOCK_SIZE;

    private final int cols;
    private final int rows;

    private final List<Coord> centerCoords = new ArrayList<>();

    public GameBoard() {
        this.BLOCK_SIZE = 25;
        this.width = 400;
        this.height = 800;

        this.cols = (width - (int)(BLOCK_SIZE * 2)) / (int) BLOCK_SIZE;
        this.rows = (height - (int)(BLOCK_SIZE * 2)) / (int) BLOCK_SIZE;

        generateCenterCoordinates();
    }

    private void generateCenterCoordinates() {
        for (int row = 0; row < rows; row++) {
            double y = BLOCK_SIZE + row * BLOCK_SIZE;
            for (int col = 0; col < cols; col++) {
                double x = BLOCK_SIZE + col * BLOCK_SIZE;
                centerCoords.add(new Coord(x, y));
            }
        }
    }

    public List<Coord> getCenterCoords() {
        return centerCoords;
    }
}
