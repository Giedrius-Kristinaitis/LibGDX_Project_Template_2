package com.gasis.template.state.update;

import com.gasis.undefined.GameStateInterface;

public interface GameStateUpdaterInterface {

    void update(double delta, GameStateInterface state);
}
