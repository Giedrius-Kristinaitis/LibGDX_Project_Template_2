package com.gasis.template.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gasis.undefined.GameStateInterface;
import com.gasis.undefined.RendererInterface;

public class GameStateRenderer {

    private final RendererInterface<Object> renderer;

    private final RendererCheckerInterface rendererChecker;

    public GameStateRenderer(RendererInterface<Object> renderer, RendererCheckerInterface rendererChecker) {
        this.renderer = renderer;
        this.rendererChecker = rendererChecker;
    }

    public void render(Batch batch, GameStateInterface state) {
        Iterable<Object> renderables = state.getObjectsToRender();

        for (Object renderable : renderables) {
            if (!rendererChecker.hasRendererFor(renderable.getClass())) {
                continue;
            }

            renderer.render(batch, renderable);
        }
    }

    public void render(ShapeRenderer shapeRenderer, GameStateInterface state) {
        Iterable<Object> renderables = state.getObjectsToRender();

        for (Object renderable : renderables) {
            if (!this.rendererChecker.hasRendererFor(renderable.getClass())) {
                continue;
            }

            renderer.render(shapeRenderer, renderable);
        }
    }
    
    public void initialize() {
        renderer.initialize();
    }
    
    public void dispose() {
        renderer.dispose();
    }
}
