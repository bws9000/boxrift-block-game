package com.burtsnyder.boxrift.core.engine;

/**
 * abstract class representing a game loop.
 * <p>This class provides structure for implementing different types of game loops
 * (i.e..., JavaFX, LibGDX, etc.) by encapsulating a {@link GameManager} and defining a contract
 * for the {@link #start()} method, which subclasses must implement to initiate the game loop.
 * <p>The {@code GameManager} handles core game logic/ updating game state,
 * allows subclasses to focus on platform-specific rendering or timing jobs.
 * @see GameManager
 */
public abstract class GameLoop {
    protected final GameManager manager;

    public GameLoop() {
        this.manager = new GameManager();
    }

    public abstract void start();
}
