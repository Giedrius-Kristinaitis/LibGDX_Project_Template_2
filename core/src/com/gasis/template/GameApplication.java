package com.gasis.template;

import com.gasis.template.resources.ResourceManagerInterface;
import com.gasis.template.screen.ScreenApplierInterface;
import com.gasis.template.screen.ScreenDestroyerInterface;
import com.gasis.template.screen.ScreenInterface;

public class GameApplication implements ScreenApplierInterface {

    private ScreenDestroyerInterface screenDestroyer;

    private ScreenApplierInterface screenApplier;

    private final ResourceManagerInterface resourceManager;

    public GameApplication(ResourceManagerInterface resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Override
    public void apply(ScreenInterface screen) {
        screenApplier.apply(screen);
    }

    public void dispose() {
        screenDestroyer.destroyScreen();
        resourceManager.dispose();
    }

    public void setScreenApplier(ScreenApplierInterface applier) {
        this.screenApplier = applier;
    }

    public void setScreenDestroyer(ScreenDestroyerInterface screenDestroyer) {
        this.screenDestroyer = screenDestroyer;
    }
}
