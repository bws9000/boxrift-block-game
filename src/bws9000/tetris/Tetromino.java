package bws9000.tetris;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.application.Platform.exit;

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

    private TetrominoBlock rectangle;
    public String shape_name;
    private int block_size;
    private int shape_grid_size;
    private int shape_size = 0;
    LinkedList<TetrominoBlock> shape;
    double[][] current_shape;
    int[] current_coordinates;

    private LinkedList<double[][]> center;
    private GameBoard game_board;
    public int center_position;


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
        this.block_size = 25;
        this.shape_grid_size = 9;
        this.center_position = 0;

        this.game_board = new GameBoard();
        this.center = this.game_board.getCenterList();
        this.shape_name = shape;
        this.shape_size = (this.shape_name.equals("I")) ? 3 : 4;
        switch (shape) {
            case "J":
                current_coordinates = init_j;
                break;
            case "S":
                current_coordinates = init_s;
                break;
            case "L":
                current_coordinates = init_l;
                break;
            case "O":
                current_coordinates = init_o; //error
                break;
            case "T":
                current_coordinates = init_t;
                break;
            case "Z":
                current_coordinates = init_z;
                break;
            case "I":
                current_coordinates = init_i;
                break;
            default:
                System.out.println("error: no shape found");
                exit();
        }
        initShape();
    }

    /**
     * add tetromino shape to board
     */
    private void initShape() {
        double[][] shape_coordinates = this.mapShape(0, 0);
        this.shape = new LinkedList<>();
        for (int i = 0; i < this.shape_size; i++) {
            this.rectangle = new TetrominoBlock(this.shape_name);
            this.rectangle.setX(shape_coordinates[i][0]);
            this.rectangle.setY(shape_coordinates[i][1]);
            if(this.setCenter(this.rectangle.getX(),this.rectangle.getY())){
                this.rectangle.setCenterNode();
            }
            this.rectangle.setShapeIndex(i);
            this.shape.add(rectangle);
        }
    }

    /**
     * rotate shape clockwise around center coordinate
     */
    private void shift_array_clockwise() {

        int[] c = this.current_coordinates;
        int[] new_array = new int[c.length];
        //before
        new_array[1] = (c[3] == 1) ? c[3] : 0;
        new_array[8] = (c[2] == 1) ? c[2] : 0;
        new_array[5] = (c[1] == 1) ? c[1] : 0;
        new_array[2] = (c[0] == 1) ? c[0] : 0;
        //after
        new_array[6] = (c[8] == 1) ? c[8] : 0;
        new_array[3] = (c[7] == 1) ? c[7] : 0;
        new_array[0] = (c[6] == 1) ? c[6] : 0;
        new_array[7] = (c[5] == 1) ? c[5] : 0;
        //center
        new_array[4] = 1;
        this.current_coordinates = new_array;
    }

    public void descend() {
        for (TetrominoBlock r : this.shape) {
            double current_y = r.getY();
            r.setY(current_y + block_size);
        }
    }

    public void moveRight() {
        for (TetrominoBlock r : this.shape) {
            double current_x = r.getX();
            r.setX(current_x + block_size);
        }
    }

    public void moveLeft() {
        for (TetrominoBlock r : this.shape) {
            double current_x = r.getX();
            r.setX(current_x - block_size);
        }
    }


    /**
     * rotate coordinates for shape using the center coordinate from
     * the board to test center position of tetromino
     */
    public void rotate() {
        shift_array_clockwise();
        if(this.center_position < this.center.size()) {
            double start_x = this.center.get(this.center_position)[0][0];
            double start_y = this.center.get(this.center_position)[0][1] - this.block_size;
            for (int i = 0; i < this.shape_size; i++) {
                this.shape.get(i).unsetCenterColor();
            }
            current_shape = mapShape(start_x, start_y);
            for (int i = 0; i < this.shape_size; i++) {
                this.shape.get(i).setX(start_x + (current_shape[i][0] - this.block_size));
                this.shape.get(i).setY(current_shape[i][1]);
                if (this.setCenter(this.shape.get(i).getX(), this.shape.get(i).getY())) {
                    this.shape.get(i).setCenterNode();
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @return center coordinates of current shape based on Gameboard linklist
     */
    private boolean setCenter(double x, double y){
        return (this.center.get(this.center_position)[0][0] == x) &&
                (this.center.get(this.center_position)[0][1] == y);
    }

    /**
     * @return shape(LinkedList of JavaFX Rectangles
     */
    public LinkedList<TetrominoBlock> getShape() {
        return this.shape;
    }


    /**
     * Returns the width of a shape
     * @return int
     */
    public int getShapeWidth() {
        List<Integer> x = new LinkedList();
        for (int i = 0; i < this.shape.size(); i++)
            x.add((int) this.shape.get(i).getX());
        List<Integer> no_duplicate_x = x.stream().distinct().collect(Collectors.toList());
        return no_duplicate_x.size() * block_size;
    }

    /**
     * Takes an array that describes a shape
     * returns coordinates of shape on game board
     * builds the shape from the top shape down
     *
     * @return shape coordinates
     */
    private double[][] mapShape(double start_x, double start_y) {
        double x = start_x;
        double y = start_y;
        double[][] coordinates = new double[shape_grid_size][2];
        double[][] shape_c = new double[shape_grid_size][2];
        //showShapeGrid();
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