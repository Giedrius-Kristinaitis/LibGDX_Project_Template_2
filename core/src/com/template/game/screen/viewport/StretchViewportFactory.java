package com.template.game.screen.viewport;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.template.game.logic.main.WorldConfigInterface;

public class StretchViewportFactory implements ViewportFactoryInterface {

    private WorldConfigInterface worldConfig;

    public StretchViewportFactory(WorldConfigInterface worldConfig) {
        this.worldConfig = worldConfig;
    }

    @Override
    public Viewport create() {
        return new StretchViewport(worldConfig.getWorldWidth(), worldConfig.getWorldHeight());
    }
}
