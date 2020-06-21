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

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

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
