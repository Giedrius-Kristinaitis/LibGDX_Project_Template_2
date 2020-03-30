package com.template.game.screen.concrete;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.template.game.screen.Screen;

public class GameScreen extends Screen {

    public GameScreen(Viewport viewport, Batch batch, InputProcessor inputProcessor, Stage stage) {
        super(viewport, batch, stage, inputProcessor);
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam, float delta) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    protected void setupUserInterface(Stage stage) {
        
    }
}
