package com.burtsnyder.blockengine.core.renderer;

import com.burtsnyder.blockengine.util.Coord;

public class GridRenderCell {
    public final Coord coord;
    public final int pixelX;
    public final int pixelY;
    public final int width;
    public final int height;

    public GridRenderCell(Coord coord, int pixelX, int pixelY, int width, int height) {
        this.coord = coord;
        this.pixelX = pixelX;
        this.pixelY = pixelY;
        this.width = width;
        this.height = height;
    }
}

