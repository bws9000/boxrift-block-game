package com.burtsnyder.blockengine.core.types;

public enum Direction {
    LEFT(true),
    RIGHT(true),
    DOWN(true),
    UP(false); //maybe i want up someday

    private final boolean enabled;

    Direction(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
