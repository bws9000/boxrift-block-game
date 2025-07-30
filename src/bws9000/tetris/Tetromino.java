package bws9000.tetris;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tetris Test with JavaFX
 *
 * @author Burt W Snyder
 * @version 0.1
 * @since 2019-09-21
 *
 * Tetromino shape for Tetris game
 */
public class Tetromino {

    public String shape_name;
    private final int block_size = 25;
    private final int shape_grid_size = 9;
    private int shape_size = 0;

    private LinkedList<TetrominoBlock> shape;
    private double[][] current_shape;
    private int[] current_coordinates;

    private final List<Coord> center;
    private final GameBoard game_board;
    public int center_position = 0;


    int[] init_i = {
            0, 1, 0,
            0, 1, 0,
            0, 1, 0
    };

    int[] init_j = {
            0, 1, 0,
            0, 1, 0,
            1, 1, 0,
    };

    int[] init_l = {
            0, 1, 0,
            0, 1, 0,
            0, 1, 1
    };

    int[] init_s = {
            0, 1, 1,
            1, 1, 0,
            0, 0, 0
    };

    int[] init_z = {
            1, 1, 0,
            0, 1, 1,
            0, 0, 0
    };

    int[] init_t = {
            1, 1, 1,
            0, 1, 0,
            0, 0, 0
    };

    int[] init_o = {
            1, 1, 1,
            1, 1, 1,
            1, 1, 1
    };


    public Tetromino(String shape) {
        this.shape_name = shape;
        this.game_board = new GameBoard();
        this.center = this.game_board.getCenterCoords();

        switch (shape) {
            case "J": current_coordinates = init_j; break;
            case "S": current_coordinates = init_s; break;
            case "L": current_coordinates = init_l; break;
            case "T": current_coordinates = init_t; break;
            case "Z": current_coordinates = init_z; break;
            case "I": current_coordinates = init_i; break;
            default: current_coordinates = init_o;
        }

        for (int val : current_coordinates) {
            if (val == 1) shape_size++;
        }
        initShape();
    }

    /**
     * add tetromino shape to board
     */
    private void initShape() {
        double[][] shape_coordinates = mapShape(0, 0);
        shape = new LinkedList<>();

        for (int i = 0; i < shape_size; i++) {
            TetrominoBlock block = new TetrominoBlock(shape_name);
            block.setX(shape_coordinates[i][0]);
            block.setY(shape_coordinates[i][1]);
            block.setShapeIndex(i);

            if (setCenter(block.getX(), block.getY())) {
                block.setCenterNode();
            }

            shape.add(block);
        }
    }

    /**
     * rotate shape clockwise around center coordinate
     */
    private void rotateCoordinatesClockwise() {
        int[] new_array = new int[9];
        int[][] grid = new int[3][3];

        for (int i = 0; i < 9; i++) {
            grid[i / 3][i % 3] = current_coordinates[i];
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                new_array[j * 3 + (2 - i)] = grid[i][j];
            }
        }

        current_coordinates = new_array;
    }

    public void descend() {
        for (TetrominoBlock r : shape) {
            r.setY(r.getY() + block_size);
        }
    }

    public void moveRight() {
        for (TetrominoBlock r : shape) {
            r.setX(r.getX() + block_size);
        }
    }

    public void moveLeft() {
        for (TetrominoBlock r : shape) {
            r.setX(r.getX() - block_size);
        }
    }


    /**
     * rotate coordinates for shape using the center coordinate from
     * the board to test center position of tetromino
     */
    public void rotate() {
        rotateCoordinatesClockwise();
        if (center_position < center.size()) {
            Coord coord = center.get(center_position);
            double start_x = coord.x;
            double start_y = coord.y;

            for (TetrominoBlock block : shape) {
                block.unsetCenterColor();
            }

            current_shape = mapShape(start_x, start_y);
            for (int i = 0; i < shape_size; i++) {
                shape.get(i).setX(start_x + (current_shape[i][0] - block_size));
                shape.get(i).setY(current_shape[i][1]);

                if (setCenter(shape.get(i).getX(), shape.get(i).getY())) {
                    shape.get(i).setCenterNode();
                }
            }
        }
    }

    private boolean setCenter(double x, double y) {
        Coord coord = center.get(center_position);
        return coord.x == x && coord.y == y;
    }

    public LinkedList<TetrominoBlock> getShape() {
        return shape;
    }

    public int getShapeWidth() {
        List<Integer> xPositions = shape.stream()
                .map(b -> (int) b.getX())
                .distinct()
                .collect(Collectors.toList());

        return xPositions.size() * block_size;
    }

    /**
     * Takes an array that describes a shape
     * returns coordinates of shape on game board
     * builds the shape from the top shape down
     *
     * @return double[][] shape coordinates
     */
    private double[][] mapShape(double start_x, double start_y) {
        double x = start_x;
        double y = start_y;
        double[][] coordinates = new double[shape_grid_size][2];
        double[][] shape_c = new double[shape_grid_size][2];

        int shape_index = 0;
        for (int i = 0; i < shape_grid_size; i++) {
            y += (i != 0 && i % 3 == 0) ? this.block_size : 0;
            x = (i % 3 == 0) ? 0 : (x += this.block_size);
            coordinates[i][0] = x;
            coordinates[i][1] = y;
            if (this.current_coordinates[i] == 1) {
                shape_c[shape_index] = coordinates[i];
                shape_index++;
            }
        }
        return shape_c;
    }
}