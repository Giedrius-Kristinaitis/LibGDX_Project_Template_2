package com.gasis.template;

import com.gasis.di.ObjectManagerInterface;
import com.gasis.undefined.RendererInterface;
import com.gasis.template.state.render.RendererProviderInterface;
import com.gasis.undefined.RendererProvider;

import java.util.HashMap;
import java.util.Map;

public class RendererRegistry implements RendererProviderInterface {

    private final ObjectManagerInterface objectManager;

    private final Map<Class<?>, RendererInterface<Object>> renderers = new HashMap<>();

    private final RendererProvider rendererProvider;
    
    public RendererRegistry(
            ObjectManagerInterface objectManager,
            RendererProvider rendererProvider
    ) {
        this.objectManager = objectManager;
        this.rendererProvider = rendererProvider;

        initialize();
    }

    @Override
    public Map<Class<?>, RendererInterface<Object>> getRenderers() {
        return renderers;
    }

    private void initialize() {
        for (Map.Entry<Class<?>, Class<?>> entry: rendererProvider.getRenderers().entrySet()) {
            registerRenderer(entry.getKey(), entry.getValue());
        }
    }

    private void registerRenderer(Class<?> type, Class<?> rendererType) {
        if (renderers.containsKey(type)) {
            throw new RuntimeException("Renderer for type " + type.getName() + " is already registered");
        }

        RendererInterface<Object> rendererInstance = (RendererInterface<Object>) objectManager.instantiate(rendererType);

        renderers.put(type, rendererInstance);
    }
}
