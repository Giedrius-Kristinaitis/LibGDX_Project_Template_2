package com.gasis.template.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gasis.undefined.RendererInterface;

import java.util.Map;

public class RendererComposite implements RendererInterface<Object>, RendererCheckerInterface {

    private final Map<Class<?>, RendererInterface<Object>> renderers;

    public RendererComposite(RendererProviderInterface rendererProvider) {
        renderers = rendererProvider.getRenderers();
    }

    @Override
    public boolean hasRendererFor(Class<?> clazz) {
        return renderers.containsKey(clazz);
    }

    @Override
    public void render(Batch batch, Object object) {
        renderers.get(object.getClass()).render(batch, object.getClass().cast(object));
    }

    @Override
    public void render(ShapeRenderer shapeRenderer, Object object) {
        renderers.get(object.getClass()).render(shapeRenderer, object.getClass().cast(object));
    }

    @Override
    public void initialize() {
        for (RendererInterface<?> renderer: renderers.values()) {
            renderer.initialize();
        }
    }

    @Override
    public void dispose() {
        for (RendererInterface<?> renderer: renderers.values()) {
            renderer.dispose();
        }
    }
}
