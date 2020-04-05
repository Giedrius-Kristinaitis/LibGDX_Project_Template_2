package com.template.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.di.ObjectManager;
import com.di.ObjectManagerInterface;
import com.template.game.screen.ScreenApplierInterface;
import com.template.game.screen.ScreenInterface;

public class ApplicationBootstrapper extends Game implements ScreenApplierInterface {

    private GameInterface game;

    public ApplicationBootstrapper() {
        bootstrap();
    }

    @Override
    public void apply(ScreenInterface screen) {
        if (!(screen instanceof Screen)) {
            throw new IllegalArgumentException("Screen must implement com.badlogic.gdx.Screen");
        }

        setScreen((Screen) screen);
    }

    @Override
    public void create() {
        // required method, but no logic goes here for now
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
    }
}
