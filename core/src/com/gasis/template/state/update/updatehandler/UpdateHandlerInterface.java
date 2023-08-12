package com.gasis.template.state.update.updatehandler;

public interface UpdateHandlerInterface {

    void start();

    void pause();

    void resume();

    void stop();

    void executeUpdates(double delta);
}
