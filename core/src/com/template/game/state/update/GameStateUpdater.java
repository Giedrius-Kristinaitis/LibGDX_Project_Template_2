package com.template.game.state.update;

import com.template.game.state.GameStateInterface;

public class GameStateUpdater implements GameStateUpdaterInterface {

    @Override
    public void update(double delta, GameStateInterface state) {
        for (UpdatableInterface updatable : state.getUpdatables()) {

        }
    }
}
