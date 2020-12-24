package com.template.game.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class AbstractScreen extends ScreenAdapter implements ScreenInterface {

    private Viewport viewport;

    private Batch batch;

    private ShapeRenderer shapeRenderer;

    private Stage stage;

    private InputProcessor inputProcessor;

    private boolean disposed;

    public AbstractScreen(Viewport viewport, Batch batch, ShapeRenderer shapeRenderer, Stage stage, InputProcessor inputProcessor) {
        this.viewport = viewport;
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.stage = stage;
        this.inputProcessor = inputProcessor;
    }

    @Override
    public void dispose() {
        disposed = true;

        batch.dispose();

        if (stage != null) {
            stage.dispose();
        }

        if (shapeRenderer != null) {
            shapeRenderer.dispose();
        }
    }

    @Override
    public InputProcessor getInputProcessor() {
        InputMultiplexer input = new InputMultiplexer();

        if (stage != null) {
            input.addProcessor(stage);
        }

        if (inputProcessor != null) {
            input.addProcessor(inputProcessor);
        }

        return input;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        performUpdates(delta);

        if (disposed) {
            return;
        }

        drawToBatch();
        drawToShapeRenderer();
        drawToStage();

        // TODO: extract com.template.game.config and io.file packages into separate repository after testing
        // TODO: finish loading screen and maybe refactor resource manager
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

        if (stage != null) {
            stage.getViewport().update(width, height, true);
        }
    }

    @Override
    public void show() {
        super.show();

        if (stage != null) {
            setupUI(stage);
        }
    }

    @Override
    public Screen toLibGDXScreen() {
        return this;
    }

    @Override
    public void update(double delta) {
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam) {
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam) {
    }

    @Override
    public void setupUI(Stage stage) {
    }

    private void performUpdates(float delta) {
        update((double) delta);
        stage.act(delta);
    }

    private void drawToBatch() {
        batch.begin();
        viewport.apply(true);
        viewport.getCamera().update();
        draw(batch, (OrthographicCamera) viewport.getCamera());
        batch.end();
    }

    private void drawToShapeRenderer() {
        if (shapeRenderer == null) {
            return;
        }

        shapeRenderer.begin();
        draw(shapeRenderer, (OrthographicCamera) viewport.getCamera());
        shapeRenderer.end();
    }

    private void drawToStage() {
        if (stage == null) {
            return;
        }

        stage.getViewport().apply();
        stage.draw();
    }
}
