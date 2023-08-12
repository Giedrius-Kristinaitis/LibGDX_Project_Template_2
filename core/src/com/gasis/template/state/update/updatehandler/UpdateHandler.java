package com.gasis.template.state.update.updatehandler;

import com.gasis.undefined.GameStateInterface;
import com.gasis.template.state.update.GameStateUpdaterInterface;

public class UpdateHandler implements UpdateHandlerInterface {

    private final GameStateInterface state;

    private final GameStateUpdaterInterface gameStateUpdater;

    private boolean paused;

    public UpdateHandler(
            GameStateUpdaterInterface gameStateUpdater,
            GameStateInterface gameState
    ) {
        this.gameStateUpdater = gameStateUpdater;
        this.state = gameState;
    }

    @Override
    public void start() {
        paused = false;
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void stop() {
        paused = true;
    }

    @Override
    public void executeUpdates(double delta) {
        if (paused) {
            return;
        }
        
        gameStateUpdater.update(delta, state);
    }
}
