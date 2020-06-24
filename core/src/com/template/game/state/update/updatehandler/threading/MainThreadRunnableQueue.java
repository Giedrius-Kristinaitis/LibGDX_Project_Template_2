package com.template.game.state.update.updatehandler.threading;

import java.util.ArrayList;
import java.util.List;

public class MainThreadRunnableQueue implements MainThreadRunnableQueueInterface {

    private final List<Runnable> oneTimeRunnables = new ArrayList<Runnable>();
    private final List<Runnable> permanentRunnables = new ArrayList<Runnable>();

    @Override
    public synchronized void addOneTimeRunnable(Runnable runnable) {
        oneTimeRunnables.add(runnable);
    }

    @Override
    public synchronized void addPermanentRunnable(Runnable runnable) {
        permanentRunnables.add(runnable);
    }

    @Override
    public synchronized void removePermanentRunnable(Runnable runnable) {
        permanentRunnables.remove(runnable);
    }

    @Override
    public synchronized void executeRunnables() {
        executeAndRemoveOneTimeRunnables();
        executePermanentRunnables();
    }

    private void executeAndRemoveOneTimeRunnables() {
        if (oneTimeRunnables.isEmpty()) {
            return;
        }

        executeRunnables(oneTimeRunnables);

        oneTimeRunnables.clear();
    }

    private void executePermanentRunnables() {
        if (permanentRunnables.isEmpty()) {
            return;
        }

        executeRunnables(permanentRunnables);
    }

    private void executeRunnables(Iterable<Runnable> runnables) {
        for (Runnable runnable : runnables) {
            runnable.run();
        }
    }
}
