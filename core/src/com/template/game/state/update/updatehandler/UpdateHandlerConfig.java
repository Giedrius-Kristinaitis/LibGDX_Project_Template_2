package com.template.game.state.update.updatehandler;

import com.template.game.config.ConfigValueProviderInterface;

public class UpdateHandlerConfig implements UpdateHandlerConfigInterface {

    private static final String CONFIG_PATH_UPDATER_THREAD_ENABLED = "general/updater-thread-enabled";

    private ConfigValueProviderInterface config;

    public UpdateHandlerConfig(ConfigValueProviderInterface config) {
        this.config = config;
    }

    @Override
    public boolean isUpdaterThreadEnabled() {
        return Boolean.parseBoolean(config.getConfigValue(CONFIG_PATH_UPDATER_THREAD_ENABLED));
    }
}
