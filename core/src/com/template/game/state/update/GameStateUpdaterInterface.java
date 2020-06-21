package com.template.game.state.update;

import com.template.game.state.GameStateInterface;

public interface GameStateUpdaterInterface {

    void update(double delta, GameStateInterface state);
}
