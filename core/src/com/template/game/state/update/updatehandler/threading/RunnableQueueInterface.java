package com.template.game.state.update.updatehandler.threading;

public interface RunnableQueueInterface {

    void addOneTimeRunnable(Runnable runnable);

    void addPermanentRunnable(Runnable runnable);

    void removePermanentRunnable(Runnable runnable);

    void executeRunnables();
}
