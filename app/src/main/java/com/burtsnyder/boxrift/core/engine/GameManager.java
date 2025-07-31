package com.burtsnyder.boxrift.core.engine;

public class GameManager implements GameEngine {

    public GameManager() {}

    @Override
    public void tick() {
        System.out.println("...tick");
    }
}