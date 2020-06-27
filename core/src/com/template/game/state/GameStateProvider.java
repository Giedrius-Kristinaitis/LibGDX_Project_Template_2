package com.template.game.state;

import com.di.ObjectManagerInterface;
import com.template.game.state.update.updatehandler.UpdateHandlerConfigInterface;

public class GameStateProvider implements GameStateProviderInterface {

    private GameStateInterface gameState;

    private ObjectManagerInterface objectManager;

    private UpdateHandlerConfigInterface config;

    public GameStateProvider(ObjectManagerInterface objectManager, UpdateHandlerConfigInterface config) {
        this.objectManager = objectManager;
        this.config = config;

        createGameState();
    }

    @Override
    public GameStateInterface getGameState() {
        return gameState;
    }

    private void createGameState() {
        if (config.isUpdaterThreadEnabled()) {
            gameState = (GameStateInterface) objectManager.instantiate(ConcurrentGameState.class);
        } else {
            gameState = (GameStateInterface) objectManager.instantiate(NonConcurrentGameState.class);
        }
    }
}
