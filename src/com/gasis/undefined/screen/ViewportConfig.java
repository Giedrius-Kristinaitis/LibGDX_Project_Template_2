package com.gasis.undefined.screen;

import com.gasis.template.config.ConfigValueProviderInterface;

public class ViewportConfig {

    private static final String CONFIG_PATH_VIEWPORT_WIDTH = "viewport/width";
    private static final String CONFIG_PATH_VIEWPORT_HEIGHT = "viewport/height";

    private final ConfigValueProviderInterface config;

    public ViewportConfig(ConfigValueProviderInterface config) {
        this.config = config;
    }

    public float getViewportWidth() {
        return Float.parseFloat(config.getConfigValue(CONFIG_PATH_VIEWPORT_WIDTH));
    }

    public float getViewportHeight() {
        return Float.parseFloat(config.getConfigValue(CONFIG_PATH_VIEWPORT_HEIGHT));
    }
}
