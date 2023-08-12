package com.gasis.template.screen;

import com.badlogic.gdx.Gdx;

public class ScreenSwitcher implements ScreenSwitcherInterface, ScreenDestroyerInterface {

    private ScreenInterface currentScreen;

    private final ScreenApplierInterface screenApplier;

    public ScreenSwitcher(ScreenApplierInterface screenApplier) {
        this.screenApplier = screenApplier;
    }

    @Override
    public void destroyScreen() {
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    public void switchToScreen(ScreenInterface newScreen) {
        destroyScreen();

        currentScreen = newScreen;

        screenApplier.apply(currentScreen);

        Gdx.input.setInputProcessor(currentScreen.getInputProcessor());
    }
}
