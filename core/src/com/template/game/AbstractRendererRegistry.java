package com.template.game;

import com.di.ObjectManagerInterface;
import com.template.game.state.render.RendererInterface;
import com.template.game.state.render.RendererProviderInterface;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRendererRegistry implements RendererProviderInterface {

    private ObjectManagerInterface objectManager;

    private Map<Class, RendererInterface<Object>> renderers = new HashMap<Class, RendererInterface<Object>>();

    public AbstractRendererRegistry(ObjectManagerInterface objectManager) {
        this.objectManager = objectManager;
    }

    void registerRenderer(Class type, Class rendererType) {
        if (renderers.containsKey(type)) {
            throw new RuntimeException("Renderer for type " + type.getName() + " is already registered");
        }

        RendererInterface<Object> rendererInstance = (RendererInterface<Object>) objectManager.instantiate(rendererType);

        renderers.put(type, rendererInstance);
    }

    @Override
    public Map<Class, RendererInterface<Object>> getRenderers() {
        return renderers;
    }

    abstract protected void initialize();
}
