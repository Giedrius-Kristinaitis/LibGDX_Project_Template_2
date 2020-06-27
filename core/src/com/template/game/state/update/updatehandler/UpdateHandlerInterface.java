package com.template.game.state.update.updatehandler;

import com.template.game.state.GameStateInterface;

public interface UpdateHandlerInterface {

    void start();

    void pause();

    void resume();

    void stop();

    void updateOnMainThread(double delta);

    void setGameState(GameStateInterface state);
}
