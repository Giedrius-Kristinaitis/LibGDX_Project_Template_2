package com.gasis.undefined;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface RendererInterface<T> {

    void render(Batch batch, T object);

    void render(ShapeRenderer shapeRenderer, T object);
    
    void initialize();
    
    void dispose();
}
