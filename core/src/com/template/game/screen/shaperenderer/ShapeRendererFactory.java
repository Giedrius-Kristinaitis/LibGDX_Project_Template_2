package com.template.game.screen.shaperenderer;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShapeRendererFactory implements ShapeRendererFactoryInterface {

    @Override
    public ShapeRenderer create() {
        ShapeRenderer renderer = new ShapeRenderer();

        renderer.setAutoShapeType(true);

        return renderer;
    }
}
