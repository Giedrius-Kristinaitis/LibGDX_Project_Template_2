package com.template.game.logic.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.template.game.screen.AbstractScreen;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.viewport.ViewportFactoryInterface;

public class LoadingScreen extends AbstractScreen {

    public LoadingScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory) {
        super(viewportFactory.create(), batchFactory.create(), null, null, null);
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam, float delta) {

    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam, float delta) {
        // no shapes to draw
    }

    @Override
    public void setupUI(Stage stage) {
        // no ui to setup
    }
}
