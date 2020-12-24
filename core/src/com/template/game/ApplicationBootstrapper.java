package com.template.game;

import com.badlogic.gdx.Game;
import com.di.ObjectManager;
import com.di.ObjectManagerInterface;
import com.template.game.logic.screen.LoadingScreen;
import com.template.game.screen.ScreenApplierInterface;
import com.template.game.screen.ScreenDestroyerInterface;
import com.template.game.screen.ScreenInterface;
import com.template.game.screen.ScreenSwitcherInterface;

public class ApplicationBootstrapper extends Game implements ScreenApplierInterface {

    private GameInterface game;

    @Override
    public void apply(ScreenInterface screen) {
        setScreen(screen.toLibGDXScreen());
    }

    @Override
    public void create() {
        bootstrap();
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    private void bootstrap() {
        ObjectManagerInterface objectManager = new ObjectManager(
                new DependencyInjectionPreferenceRegistry(),
                new DependencyInjectionArgumentRegistry()
        );

        game = (GameInterface) objectManager.instantiate(GameInterface.class);
        game.setScreenApplier(this);

        ScreenDestroyerInterface screenDestroyer = (ScreenDestroyerInterface) objectManager.instantiate(ScreenDestroyerInterface.class);
        game.setScreenDestroyer(screenDestroyer);

        ScreenSwitcherInterface screenSwitcher = (ScreenSwitcherInterface) objectManager.instantiate(ScreenSwitcherInterface.class);

        LoadingScreen loadingScreen = (LoadingScreen) objectManager.instantiate(LoadingScreen.class);

        screenSwitcher.switchScreen(loadingScreen);
    }
}
