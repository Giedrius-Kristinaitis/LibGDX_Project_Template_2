package com.template.game.state.render;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.template.game.state.GameStateInterface;

public interface GameStateRendererInterface {

    void render(Batch batch, GameStateInterface state);

    void render(ShapeRenderer shapeRenderer, GameStateInterface state);
}
