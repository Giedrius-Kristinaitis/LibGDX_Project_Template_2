package com.template.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.istack.internal.NotNull;

public abstract class AbstractScreen extends ScreenAdapter implements ScreenInterface {

    private Viewport viewport;

    private Batch batch;

    private ShapeRenderer shapeRenderer;

    private Stage stage;

    private InputProcessor inputProcessor;

    private boolean disposed;

    public AbstractScreen(@NotNull Viewport viewport, @NotNull Batch batch, ShapeRenderer shapeRenderer, Stage stage, InputProcessor inputProcessor) {
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
        
        // TODO: refactor method into two threads - renderer and updater (which will be optional)
        // TODO: create render queue, add shape renderer on top of the sprite batch
        // TODO: split rendering and updating responsibilities into two classes
        // TODO: maybe refactor this class just a little bit
        // TODO: refactor resource manager (and remove redundant comments)
        // TODO: load resources for each screen individually (maybe)
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
        viewport.apply(true);
        viewport.getCamera().update();
        draw(batch, (OrthographicCamera) viewport.getCamera());
    }

    private void drawToShapeRenderer() {
        if (shapeRenderer == null) {
            return;
        }

        draw(shapeRenderer, (OrthographicCamera) viewport.getCamera());
    }

    private void drawToStage() {
        if (stage == null) {
            return;
        }

        stage.getViewport().apply();
        stage.draw();
    }
}
