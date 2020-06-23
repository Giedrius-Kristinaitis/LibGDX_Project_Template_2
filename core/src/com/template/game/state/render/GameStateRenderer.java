package com.template.game.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.template.game.state.GameStateInterface;

public class GameStateRenderer implements GameStateRendererInterface {

    private RendererInterface<Object> renderer;

    private RendererCheckerInterface rendererChecker;

    public GameStateRenderer(RendererInterface<Object> renderer, RendererCheckerInterface rendererChecker) {
        this.renderer = renderer;
        this.rendererChecker = rendererChecker;
    }

    @Override
    public void render(Batch batch, GameStateInterface state) {
        Iterable<Object> renderables = state.getRenderables();

        for (Object renderable : renderables) {
            if (!rendererChecker.hasRendererFor(renderable.getClass())) {
                continue;
            }

            renderer.render(batch, renderable);
        }
    }

    @Override
    public void render(ShapeRenderer shapeRenderer, GameStateInterface state) {
        Iterable<Object> renderables = state.getRenderables();

        for (Object renderable : renderables) {
            if (!this.rendererChecker.hasRendererFor(renderable.getClass())) {
                continue;
            }

            renderer.render(shapeRenderer, renderable);
        }
    }
}
