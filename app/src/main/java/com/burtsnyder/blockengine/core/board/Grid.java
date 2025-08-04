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


    public void setBlockAt(int x, int y, Block block) {
        cells[x][y].setBlock(block);
    }

    public Long getBlockIdAt(int x, int y) {
        return cells[y][x].getBlockId();
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setBlockAt(Coord coord, Block block) {
        setBlockAt(coord.row(),coord.col(), block);
    }

    public Cell getCell(Coord coord) {
        return getCell(coord.row(),coord.col());
    }

}
