package com.gasis.undefined.logic;

import com.gasis.undefined.GameStateInterface;

public class Game {

    private final GameStateInterface gameState;

    public Game(
            GameStateInterface gameState
    ) {
        this.gameState = gameState;
    }

    public void initialize() {
        // TODO: perform all game mechanics specific initialization here
        
    }

    public void dispose() {
        // TODO: get rid of all game mechanics specific resources that were initialized in this class
    }
}
