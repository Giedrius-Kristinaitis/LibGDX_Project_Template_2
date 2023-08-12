package com.gasis.template;

import com.badlogic.gdx.Game;
import com.gasis.di.ObjectManager;
import com.gasis.di.ObjectManagerInterface;
import com.gasis.undefined.screen.GameScreen;
import com.gasis.undefined.screen.LoadingScreen;
import com.gasis.template.screen.ScreenApplierInterface;
import com.gasis.template.screen.ScreenDestroyerInterface;
import com.gasis.template.screen.ScreenInterface;
import com.gasis.template.screen.ScreenSwitcherInterface;

public class ApplicationBootstrapper extends Game implements ScreenApplierInterface {

    private GameApplication game;

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

        game = (GameApplication) objectManager.instantiate(GameApplication.class);
        game.setScreenApplier(this);

        ScreenDestroyerInterface screenDestroyer = (ScreenDestroyerInterface) objectManager.instantiate(ScreenDestroyerInterface.class);
        game.setScreenDestroyer(screenDestroyer);

        ScreenSwitcherInterface screenSwitcher = (ScreenSwitcherInterface) objectManager.instantiate(ScreenSwitcherInterface.class);

        LoadingScreen loadingScreen = (LoadingScreen) objectManager.instantiate(LoadingScreen.class);
        GameScreen gameScreen = (GameScreen) objectManager.instantiate(GameScreen.class);

        loadingScreen.setScreenToSwitchTo(gameScreen);

        screenSwitcher.switchToScreen(loadingScreen);
    }
}
