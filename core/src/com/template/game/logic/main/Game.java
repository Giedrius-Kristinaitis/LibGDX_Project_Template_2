package com.template.game.logic.main;

import com.template.game.state.GameStateInterface;
import com.template.game.state.GameStateProviderInterface;

public class Game {

    private GameStateInterface gameState;

    public Game(GameStateProviderInterface gameStateProvider) {
        this.gameState = gameStateProvider.getGameState();
    }

    public void initialize() {
        // TODO: perform all game mechanics specific initialization here
    }

    public void dispose() {
        // TODO: get rid of all game mechanics specific resources that were initialized in this class
    }
}
