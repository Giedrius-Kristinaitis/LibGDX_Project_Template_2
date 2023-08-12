package com.gasis.template.screen.batch;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteBatchFactory implements BatchFactoryInterface {

    @Override
    public Batch create() {
        return new SpriteBatch();
    }
}
