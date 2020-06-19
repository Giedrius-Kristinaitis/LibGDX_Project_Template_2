package com.template.game.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface RendererInterface<T> {

    void render(Batch batch, T object);
}
