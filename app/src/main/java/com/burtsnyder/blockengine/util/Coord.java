package com.burtsnyder.blockengine.util;


/**
 * @param x column
 * @param y row
 */
public record Coord(int x, int y) {

    public int col() {
        return x;
    }

    public int row() {
        return y;
    }

    public Coord add(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }

//    public Coord up() {
//        return new Coord(x, y - 1);
//    }

//    public Coord down() {
//        return new Coord(x, y + 1);
//    }
//
//    public Coord left() {
//        return new Coord(x - 1, y);
//    }
//
//    public Coord right() {
//        return new Coord(x + 1, y);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord coord)) return false;
        return x == coord.x && y == coord.y;
    }

//    @Override
//    public String toString() {
//        return "(" + x + "," + y + ")";
//    }
}


