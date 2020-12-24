package com.template.game.logic.main;

import com.template.game.config.ConfigValueProviderInterface;

public class WorldConfig implements WorldConfigInterface {

    private static final String CONFIG_PATH_WORLD_WIDTH = "game_world/width";
    private static final String CONFIG_PATH_WORLD_HEIGHT = "game_world/height";

    private ConfigValueProviderInterface config;

    public WorldConfig(ConfigValueProviderInterface config) {
        this.config = config;
    }

    @Override
    public float getWorldWidth() {
        return Float.parseFloat(config.getConfigValue(CONFIG_PATH_WORLD_WIDTH));
    }

    @Override
    public float getWorldHeight() {
        return Float.parseFloat(config.getConfigValue(CONFIG_PATH_WORLD_HEIGHT));
    }
}
