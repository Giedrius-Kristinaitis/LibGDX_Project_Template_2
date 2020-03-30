package com.template.game.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public interface ScreenInterface extends Disposable {

    void draw(Batch batch, OrthographicCamera cam, float delta);

    InputProcessor getInputProcessor();

    void update(float delta);
}
