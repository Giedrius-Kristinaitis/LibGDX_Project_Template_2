package com.template.game.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface ScreenInterface extends Screen {

    void draw(Batch batch, OrthographicCamera cam, float delta);

    void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam, float delta);

    void setupUI(Stage stage);

    InputProcessor getInputProcessor();
}
