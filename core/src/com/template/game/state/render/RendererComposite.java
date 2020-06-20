package com.template.game.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Map;

public class RendererComposite implements RendererInterface<Object>, RendererCheckerInterface {

    private Map<Class, RendererInterface<Object>> renderers;

    public RendererComposite(RendererProviderInterface rendererProvider) {
        renderers = rendererProvider.getRenderers();
    }

    @Override
    public boolean hasRendererFor(Object object) {
        return renderers.containsKey(object.getClass());
    }

    @Override
    public void render(Batch batch, Object object) {
        renderers.get(object.getClass()).render(batch, object.getClass().cast(object));
    }

    @Override
    public void render(ShapeRenderer shapeRenderer, Object object) {
        renderers.get(object.getClass()).render(shapeRenderer, object.getClass().cast(object));
    }
}
