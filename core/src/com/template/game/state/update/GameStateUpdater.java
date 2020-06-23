package com.template.game.state.update;

import com.template.game.state.GameStateInterface;

public class GameStateUpdater implements GameStateUpdaterInterface {

    private UpdaterInterface<Object> updater;

    private UpdaterCheckerInterface updaterChecker;

    public GameStateUpdater(UpdaterInterface<Object> updater, UpdaterCheckerInterface updaterChecker) {
        this.updater = updater;
        this.updaterChecker = updaterChecker;
    }

    @Override
    public void update(double delta, GameStateInterface state) {
        for (Object updatable : state.getObjects()) {
            if (!updaterChecker.hasUpdaterFor(updatable.getClass())) {
                continue;
            }

            updater.update(updatable, delta);
        }
    }
}
