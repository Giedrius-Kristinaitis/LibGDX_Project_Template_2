package com.gasis.template.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Map;

public interface ScreenInterface {

    void dispose();

    void draw(Batch batch, OrthographicCamera cam);

    void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam);

    void update(double delta);

    void setupUI(Stage stage);

    Map<String, Class<?>> getAssetsToLoad();

    InputProcessor getInputProcessor();

    Screen toLibGDXScreen();
}
