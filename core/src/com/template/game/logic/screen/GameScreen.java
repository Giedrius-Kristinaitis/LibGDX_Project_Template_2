package com.template.game.logic.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.template.game.logic.main.Game;
import com.template.game.screen.AbstractScreen;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.shaperenderer.ShapeRendererFactoryInterface;
import com.template.game.screen.stage.StageFactoryInterface;
import com.template.game.screen.viewport.ViewportFactoryInterface;
import com.template.game.state.GameStateProviderInterface;
import com.template.game.state.render.GameStateRendererInterface;
import com.template.game.state.update.updatehandler.UpdateHandlerFactoryInterface;
import com.template.game.state.update.updatehandler.UpdateHandlerInterface;

import java.util.Map;

public class GameScreen extends AbstractScreen {

    private GameStateProviderInterface gameStateProvider;

    private GameStateRendererInterface gameStateRenderer;

    private UpdateHandlerInterface updateHandler;

    private Game game;

    public GameScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory, ShapeRendererFactoryInterface shapeRendererFactory, StageFactoryInterface stageFactory, GameStateProviderInterface gameStateProvider, GameStateRendererInterface gameStateRenderer, UpdateHandlerFactoryInterface updateHandlerFactory, Game game) {
        super(viewportFactory.create(), batchFactory.create(), shapeRendererFactory.create(), stageFactory.create(), null);

        this.game = game;
        this.gameStateProvider = gameStateProvider;
        this.gameStateRenderer = gameStateRenderer;
        this.updateHandler = updateHandlerFactory.create(gameStateProvider.getGameState());
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam) {
        gameStateRenderer.render(batch, gameStateProvider.getGameState());
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam) {
        gameStateRenderer.render(shapeRenderer, gameStateProvider.getGameState());
    }

    @Override
    public void update(double delta) {
        updateHandler.updateOnMainThread(delta);
    }

    @Override
    public void setupUI(Stage stage) {
        // TODO: setup game screen ui
    }

    @Override
    public Map<String, Class> getAssetsToLoad() {
        // TODO: define assets to be loaded, preferably, create a new class that acts as a registry, to avoid populating this class with a lot of code
        return null;
    }

    @Override
    public void pause() {
        super.pause();
        updateHandler.pause();
    }

    @Override
    public void resume() {
        super.resume();
        updateHandler.resume();
    }

    @Override
    public void show() {
        super.show();
        game.initialize();
        updateHandler.start();
    }

    @Override
    public void hide() {
        super.hide();
        game.dispose();
        updateHandler.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
        updateHandler.stop();
    }
}
