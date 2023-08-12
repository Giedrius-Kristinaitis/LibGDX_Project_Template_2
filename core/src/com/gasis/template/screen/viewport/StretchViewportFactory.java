package com.gasis.template.screen.viewport;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gasis.undefined.screen.ViewportConfig;

public class StretchViewportFactory implements ViewportFactoryInterface {

    private final ViewportConfig worldConfig;

    public StretchViewportFactory(ViewportConfig worldConfig) {
        this.worldConfig = worldConfig;
    }

    @Override
    public Viewport create() {
        return new StretchViewport(worldConfig.getViewportWidth(), worldConfig.getViewportHeight());
    }
}
