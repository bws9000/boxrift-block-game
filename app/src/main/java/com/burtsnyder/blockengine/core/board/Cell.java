package com.burtsnyder.blockengine.core.board;

import com.burtsnyder.blockengine.core.block.Block;
import com.burtsnyder.blockengine.core.block.BlockMetadata;

public class Cell {
    private Block block;
    private BlockMetadata metadata;

    public Cell() {
        this.block = null;
        this.metadata = null;
    }

    public boolean isEmpty() {
        return block == null;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public BlockMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(BlockMetadata metadata) {
        this.metadata = metadata;
    }

    public Long getBlockId() {
        return block != null ? block.getMetadata().getPieceId() : null;
    }
}
