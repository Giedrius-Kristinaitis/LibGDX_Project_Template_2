package com.template.game;

import com.di.registry.AbstractPreferenceRegistry;
import com.template.game.resources.ResourceManager;
import com.template.game.resources.ResourceManagerInterface;

public class DependencyInjectionPreferenceRegistry extends AbstractPreferenceRegistry {

    @Override
    protected void initialize() {
        registerPreference(ResourceManagerInterface.class, ResourceManager.class);
    }
}
