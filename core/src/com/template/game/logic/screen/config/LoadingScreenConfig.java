package com.template.game.logic.screen.config;

import com.template.game.config.ConfigValueProviderInterface;

public class LoadingScreenConfig implements LoadingScreenConfigInterface {

    private static final String CONFIG_PATH_SPLASH_IMAGE = "loading_screen/splash_image";

    private ConfigValueProviderInterface configValueProvider;

    public LoadingScreenConfig(ConfigValueProviderInterface configValueProvider) {
        this.configValueProvider = configValueProvider;
    }

    @Override
    public String getSplashImageName() {
        return configValueProvider.getConfigValue(CONFIG_PATH_SPLASH_IMAGE);
    }
}
