package com.template.game.logic.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.template.game.screen.AbstractScreen;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.shaperenderer.ShapeRendererFactoryInterface;
import com.template.game.screen.stage.StageFactoryInterface;
import com.template.game.screen.viewport.ViewportFactoryInterface;
import com.template.game.state.GameStateInterface;
import com.template.game.state.render.GameStateRendererInterface;

public class GameScreen extends AbstractScreen {

    private GameStateInterface gameState;

    private GameStateRendererInterface gameStateRenderer;

    public GameScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory, ShapeRendererFactoryInterface shapeRendererFactory, StageFactoryInterface stageFactory, GameStateInterface gameState, GameStateRendererInterface gameStateRenderer) {
        super(viewportFactory.create(), batchFactory.create(), shapeRendererFactory.create(), stageFactory.create(), null);

        this.gameState = gameState;
        this.gameStateRenderer = gameStateRenderer;
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam, float delta) {
        gameStateRenderer.render(batch, gameState);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam, float delta) {
        gameStateRenderer.render(shapeRenderer, gameState);
    }

    @Override
    public void setupUI(Stage stage) {

    }

    @Override
    public void dispose() {
        super.dispose();


    }
}
