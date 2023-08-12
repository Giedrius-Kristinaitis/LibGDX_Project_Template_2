package com.gasis.undefined.screen.config;

import com.gasis.template.config.ConfigValueProviderInterface;

public class LoadingScreenConfig {

    private static final String CONFIG_PATH_SPLASH_IMAGE = "loading_screen/splash_image";

    private final ConfigValueProviderInterface configValueProvider;

    public LoadingScreenConfig(ConfigValueProviderInterface configValueProvider) {
        this.configValueProvider = configValueProvider;
    }

    public String getSplashImageName() {
        return configValueProvider.getConfigValue(CONFIG_PATH_SPLASH_IMAGE);
    }
}
