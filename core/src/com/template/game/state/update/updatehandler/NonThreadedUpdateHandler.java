package com.template.game.state.update.updatehandler;

import com.template.game.state.GameStateInterface;
import com.template.game.state.update.GameStateUpdaterInterface;

public class NonThreadedUpdateHandler implements UpdateHandlerInterface {

    private GameStateInterface state;

    private GameStateUpdaterInterface gameStateUpdater;

    public NonThreadedUpdateHandler(GameStateUpdaterInterface gameStateUpdater) {
        this.gameStateUpdater = gameStateUpdater;
    }

    @Override
    public void start() {
        // nothing to do here, because it runs on the main thread
    }

    @Override
    public void pause() {
        // nothing to do here, because it runs on the main thread
    }

    @Override
    public void resume() {
        // nothing to do here, because it runs on the main thread
    }

    @Override
    public void stop() {
        // nothing to do here, because it runs on the main thread
    }

    @Override
    public void update(double delta) {
        gameStateUpdater.update(delta, state);
    }

    @Override
    public void setGameState(GameStateInterface state) {
        this.state = state;
    }
}
