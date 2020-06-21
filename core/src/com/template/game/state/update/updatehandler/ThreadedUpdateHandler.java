package com.template.game.state.update.updatehandler;

import com.template.game.state.GameStateInterface;
import com.template.game.state.update.GameStateUpdaterInterface;

public class ThreadedUpdateHandler implements UpdateHandlerInterface, Runnable {

    private GameStateInterface state;

    private GameStateUpdaterInterface gameStateUpdater;

    private Thread updaterThread;

    private volatile boolean paused;

    public ThreadedUpdateHandler(GameStateUpdaterInterface gameStateUpdater) {
        this.gameStateUpdater = gameStateUpdater;
    }

    @Override
    public void start() {
        updaterThread = new Thread(this);
        updaterThread.start();
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
        // nothing to do here, because the update logic runs on another thread
    }

    @Override
    public void setGameState(GameStateInterface state) {
        this.state = state;
    }

    @Override
    public void run() {
        // TODO: create game loop
        //gameStateUpdater.update(state);
    }
}
