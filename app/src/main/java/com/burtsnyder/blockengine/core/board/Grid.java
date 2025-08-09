package com.burtsnyder.blockengine.core.board;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.util.Coord;

public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[x][y] = new Cell();
            }
        }
    }


//    public void setBlockAt(int x, int y, Block block) {
//        cells[x][y].setBlock(block);
//    }

    public Long getBlockIdAt(int x, int y) {
        return cells[x][y].getBlockId();
    }

//    public Cell getCell(int x, int y) {
//        return cells[x][y];
//    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

//    public void setBlockAt(Coord coord, Block block) {
//        setBlockAt(coord.col(),coord.row(), block);
//    }
//
//    public Cell getCell(Coord coord) {
//
//        return getCell(coord.col(),coord.row());
//    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public boolean isEmpty(int x, int y) {
        return cells[x][y].getBlock() == null;
    }

}
