package com.burtsnyder.blockengine.util;

import java.util.Objects;

public class Coord {
    public final int x;
    public final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord add(int dx, int dy) {
        return new Coord(this.x + dx, this.y + dy);
    }

    public Coord up() {
        return new Coord(this.x, this.y - 1);
    }

    public Coord down() {
        return new Coord(this.x, this.y + 1);
    }

    public Coord left() {
        return new Coord(this.x - 1, this.y);
    }

    public Coord right() {
        return new Coord(this.x + 1, this.y);
    }

    //later
    public int manhattanDistance(Coord other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord coord)) return false;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}


