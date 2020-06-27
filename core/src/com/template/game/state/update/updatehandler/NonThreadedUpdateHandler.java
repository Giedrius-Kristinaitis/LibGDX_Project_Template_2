package com.template.game.state.update.updatehandler;

import com.template.game.state.GameStateInterface;
import com.template.game.state.update.GameStateUpdaterInterface;

public class NonThreadedUpdateHandler implements UpdateHandlerInterface {

    private GameStateInterface state;

    private GameStateUpdaterInterface gameStateUpdater;

    private boolean paused;

    public NonThreadedUpdateHandler(GameStateUpdaterInterface gameStateUpdater) {
        this.gameStateUpdater = gameStateUpdater;
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
    public void updateOnMainThread(double delta) {
        if (paused) {
            return;
        }
        
        gameStateUpdater.update(delta, state);
    }

    @Override
    public void setGameState(GameStateInterface state) {
        this.state = state;
    }
}
