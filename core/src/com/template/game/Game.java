package com.template.game;

import com.template.game.resources.ResourceManagerInterface;
import com.template.game.screen.ScreenApplierInterface;
import com.template.game.screen.ScreenDestroyerInterface;
import com.template.game.screen.ScreenInterface;

public class Game implements GameInterface, ScreenApplierInterface {

    private ScreenDestroyerInterface screenDestroyer;

    private ScreenApplierInterface screenApplier;

    private ResourceManagerInterface resourceManager;

    public Game(ScreenDestroyerInterface screenDestroyer, ResourceManagerInterface resourceManager) {
        this.screenDestroyer = screenDestroyer;
        this.resourceManager = resourceManager;
    }

    @Override
    public void apply(ScreenInterface screen) {
        screenApplier.apply(screen);
    }

    @Override
    public void dispose() {
        screenDestroyer.destroyScreen();
        resourceManager.dispose();
    }

    @Override
    public void setScreenApplier(ScreenApplierInterface applier) {
        this.screenApplier = applier;
    }
}
