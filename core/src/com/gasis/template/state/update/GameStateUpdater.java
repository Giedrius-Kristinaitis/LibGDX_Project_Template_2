package com.gasis.template.state.update;

import com.gasis.undefined.GameStateInterface;
import com.gasis.undefined.UpdatableInterface;

public class GameStateUpdater implements GameStateUpdaterInterface {

    @Override
    public void update(double delta, GameStateInterface state) {
        for (UpdatableInterface updatable : state.getUpdatables()) {
            updatable.update(delta);
        }
    }
}
