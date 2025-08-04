package com.burtsnyder.blockengine.core.board;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockMetadata;
import com.burtsnyder.blockengine.util.Coord;

public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell();
            }
        }
    }

    public void setBlockAt(int x, int y, Block block) {
        cells[y][x].setBlock(block);
    }

    public void setMetadataAt(int x, int y, BlockMetadata metadata) {
        cells[y][x].setMetadata(metadata);
    }


    public boolean isOccupied(int x, int y) {
        return !cells[y][x].isEmpty();
    }

    public Long getBlockIdAt(int x, int y) {
        return cells[y][x].getBlockId();
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setBlockAt(Coord coord, Block block) {
        setBlockAt(coord.col(), coord.row(), block);
    }

    public void setMetadataAt(Coord coord, BlockMetadata metadata) {
        setMetadataAt(coord.col(), coord.row(), metadata);
    }

    public Cell getCell(Coord coord) {
        return getCell(coord.col(), coord.row());
    }

    /*
    public void lockActor(Actor actor) {
        for (Block block : actor.getBlocks()) {
            int row = block.getRow();
            int col = block.getCol();

            if (row >= 0 && row < height && col >= 0 && col < width) {
                Cell cell = getCell(col, row);// todo:update indexing [y][x] DOH!
                BlockMetadata updatedMeta = cell.getMetadata().copyWith(
                        actor.getId(),  // pieceId
                        actor.getGroupId(),
                        true,// Locked
                        false
                );
                cell.setBlock(block);
                cell.setMetadata(updatedMeta);
            }
        }
    }
     */

}
