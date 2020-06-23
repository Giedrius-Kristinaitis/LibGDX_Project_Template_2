package com.template.game;

import com.template.game.config.ConfigValueProviderInterface;

public class PerformanceConfig implements PerformanceConfigInterface {

    private static final String CONFIG_PATH_TARGET_UPDATES_PER_SECOND = "threading_and_performance/target_updates_per_second";

    private ConfigValueProviderInterface config;

    public PerformanceConfig(ConfigValueProviderInterface config) {
        this.config = config;
    }

    @Override
    public double getTargetUpdatesPerSecond() {
        String updatesPerSecond = config.getConfigValue(CONFIG_PATH_TARGET_UPDATES_PER_SECOND);

        if (updatesPerSecond == null) {
            throw new RuntimeException("threading_and_performance/target_updates_per_second config must be set");
        }

        return Double.parseDouble(updatesPerSecond);
    }
}
