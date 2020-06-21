package com.template.game.logic.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.template.game.screen.AbstractScreen;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.viewport.ViewportFactoryInterface;

public class LoadingScreen extends AbstractScreen {

    public LoadingScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory) {
        super(viewportFactory.create(), batchFactory.create(), null, null, null);
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam, double delta) {

    }
}
