package com.template.game.state.update.updatehandler;

import com.di.annotation.Parameters;
import com.template.game.PerformanceConfigInterface;
import com.template.game.state.GameStateInterface;
import com.template.game.state.update.GameStateUpdaterInterface;
import com.template.game.state.update.updatehandler.threading.MainThreadRunnableQueueInterface;

public class ConcurrentUpdateHandler implements UpdateHandlerInterface, Runnable {

    private GameStateInterface state;

    private GameStateUpdaterInterface gameStateUpdater;

    private PerformanceConfigInterface config;

    private Thread updaterThread;

    private MainThreadRunnableQueueInterface runnableQueue;

    private volatile boolean needsTermination;
    private volatile boolean paused;

    @Parameters({"gameStateUpdater", "config", "runnableQueue"})
    public ConcurrentUpdateHandler(GameStateUpdaterInterface gameStateUpdater, PerformanceConfigInterface config, MainThreadRunnableQueueInterface runnableQueue) {
        this.gameStateUpdater = gameStateUpdater;
        this.config = config;
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void start() {
        paused = false;
        needsTermination = false;
        updaterThread = new Thread(this);
        updaterThread.start();
    }

    @Override
    public void pause() {
        synchronized (this) {
            paused = true;
            notifyAll();
        }
    }

    @Override
    public void resume() {
        synchronized (this) {
            paused = false;
            notifyAll();
        }
    }

    @Override
    public void stop() {
        synchronized (this) {
            needsTermination = true;
            notifyAll();
        }
    }

    @Override
    public void updateOnMainThread(double delta) {
        runnableQueue.executeRunnables();
    }

    @Override
    public void setGameState(GameStateInterface state) {
        this.state = state;
    }

    @Override
    public void run() {
        executeUpdateLoop();
    }

    private void executeUpdateLoop() {
        UpdateLoop updateLoop = createInitialUpdateLoop();

        while (!needsTermination) {
            waitIfPaused();
            executeUpdateTicks(updateLoop);
        }
    }

    private void executeUpdateTicks(UpdateLoop updateLoop) {
        updateLoop.incrementDeltaValue();

        while (updateLoop.delta >= 1) {
            executeUpdateTick((updateLoop.currentTimeInNanoseconds - updateLoop.lastUpdateTimeInNanoseconds) / 1000D);
            updateLoop.decrementDeltaValue();
        }
    }

    private void executeUpdateTick(double millisecondsSinceLastUpdate) {
        gameStateUpdater.update(millisecondsSinceLastUpdate, state);
    }

    private void waitIfPaused() {
        synchronized (this) {
            while (paused) {
                executeThreadWaiting();
            }
        }
    }

    private void executeThreadWaiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {

        }
    }

    private UpdateLoop createInitialUpdateLoop() {
        UpdateLoop updateLoop = new UpdateLoop();

        updateLoop.lastUpdateTimeInNanoseconds = System.nanoTime();

        return updateLoop;
    }

    private class UpdateLoop {

        protected long lastUpdateTimeInNanoseconds;
        protected double targetUpdatesPerSecond;
        protected double cycleTimeInNanoseconds;
        protected long currentTimeInNanoseconds;
        protected double delta;

        protected UpdateLoop() {
            targetUpdatesPerSecond = config.getTargetUpdatesPerSecond();
            cycleTimeInNanoseconds = 1000000000 / targetUpdatesPerSecond;
        }

        protected void incrementDeltaValue() {
            currentTimeInNanoseconds = System.nanoTime();
            delta += (currentTimeInNanoseconds - lastUpdateTimeInNanoseconds) / cycleTimeInNanoseconds;
            lastUpdateTimeInNanoseconds = currentTimeInNanoseconds;
        }

        protected void decrementDeltaValue() {
            delta--;
        }
    }
}
