package test;

import bws9000.tetris.Tetromino;
import bws9000.tetris.TetrominoBlock;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class TetrominoTest {

    @Before
    public void setUp() throws Exception {
        //
    }

    @Test
    public void testZShapeWidth(){
        Tetromino tetromino = new Tetromino("Z");
        assertEquals(75, tetromino.getShapeWidth());
    }

    @Test
    public void testLShapeWidth(){
        Tetromino tetromino = new Tetromino("L");
        assertEquals(50, tetromino.getShapeWidth());
    }

    @Test
    public void testSCenterNode(){
        Tetromino tetromino = new Tetromino("S");
        LinkedList<TetrominoBlock> t = tetromino.getShape();
        assertEquals(true, t.get(2).isCenter_node());
    }

    @Test
    public void testCenterNode(){
        Tetromino tetromino = new Tetromino("O");
        LinkedList<TetrominoBlock> t = tetromino.getShape();
        assertEquals(true, t.get(1).isCenter_node());
    }

    @Test
    public void testShapeDisplayedEvenlyWidthOnGrid(){
        Tetromino tetromino = new Tetromino("L");
        assertEquals(0, 400 % tetromino.getShapeWidth());
    }
}