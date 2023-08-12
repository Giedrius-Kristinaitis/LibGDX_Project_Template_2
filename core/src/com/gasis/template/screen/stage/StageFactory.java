package com.gasis.template.screen.stage;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class StageFactory implements StageFactoryInterface {

    @Override
    public Stage create() {
        return new Stage();
    }
}
