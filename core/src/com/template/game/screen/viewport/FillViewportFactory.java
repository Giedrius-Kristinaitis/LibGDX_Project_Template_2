package com.template.game.screen.viewport;

import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.template.game.logic.main.WorldConfigInterface;

public class FillViewportFactory implements ViewportFactoryInterface {

    private WorldConfigInterface worldConfig;

    public FillViewportFactory(WorldConfigInterface worldConfig) {
        this.worldConfig = worldConfig;
    }

    @Override
    public Viewport create() {
        return new FillViewport(worldConfig.getWorldWidth(), worldConfig.getWorldHeight());
    }
}
