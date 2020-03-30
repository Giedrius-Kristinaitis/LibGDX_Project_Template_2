package com.template.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class Screen extends ScreenAdapter implements ScreenInterface {

    private Viewport viewport;

    private Batch batch;

    private Stage stage;

    private InputProcessor inputProcessor;

    private boolean disposed;

    public Screen(Viewport viewport, Batch batch, Stage stage, InputProcessor inputProcessor) {
        this.viewport = viewport;
        this.batch = batch;
        this.stage = stage;
        this.inputProcessor = inputProcessor;

        initialize();
    }

    @Override
    public void dispose() {
        disposed = true;

        batch.dispose();
        stage.dispose();
    }

    @Override
    public InputProcessor getInputProcessor() {
        InputMultiplexer input = new InputMultiplexer();

        input.addProcessor(stage);
        input.addProcessor(inputProcessor);

        return input;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        if (disposed) {
            return;
        }

        viewport.apply(true);
        viewport.getCamera().update();
        draw(batch, (OrthographicCamera) viewport.getCamera(), delta);

        stage.getViewport().apply();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        super.show();

        setupUserInterface(stage);
    }

    private void initialize() {
        viewport.apply(true);
    }

    protected abstract void setupUserInterface(Stage stage);
}
