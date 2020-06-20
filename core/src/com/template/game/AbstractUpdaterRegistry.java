package com.template.game;

import com.di.ObjectManagerInterface;
import com.template.game.state.update.UpdaterInterface;
import com.template.game.state.update.UpdaterProviderInterface;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUpdaterRegistry implements UpdaterProviderInterface {

    private ObjectManagerInterface objectManager;

    private Map<Class, UpdaterInterface<Object>> updaters = new HashMap<Class, UpdaterInterface<Object>>();

    public AbstractUpdaterRegistry(ObjectManagerInterface objectManager) {
        this.objectManager = objectManager;
    }

    void registerRenderer(Class type, Class rendererType) {
        if (updaters.containsKey(type)) {
            throw new RuntimeException("Updater for type " + type.getName() + " is already registered");
        }

        UpdaterInterface<Object> rendererInstance = (UpdaterInterface<Object>) objectManager.instantiate(rendererType);

        updaters.put(type, rendererInstance);
    }

    @Override
    public Map<Class, UpdaterInterface<Object>> getUpdaters() {
        return updaters;
    }

    abstract protected void initialize();
}
