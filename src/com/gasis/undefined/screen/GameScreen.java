package com.gasis.undefined.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gasis.template.state.GameState;
import com.gasis.undefined.logic.Game;
import com.gasis.template.screen.AbstractScreen;
import com.gasis.template.screen.batch.BatchFactoryInterface;
import com.gasis.template.screen.shaperenderer.ShapeRendererFactoryInterface;
import com.gasis.template.screen.stage.StageFactoryInterface;
import com.gasis.template.screen.viewport.ViewportFactoryInterface;
import com.gasis.template.state.render.GameStateRenderer;
import com.gasis.template.state.update.updatehandler.UpdateHandlerInterface;

import java.util.Map;
import java.util.TreeMap;

public class GameScreen extends AbstractScreen {

    private final GameStateRenderer gameStateRenderer;

    private final UpdateHandlerInterface updateHandler;
    
    private final GameState gameState;

    private final Game game;

    public GameScreen(
            ViewportFactoryInterface viewportFactory, 
            BatchFactoryInterface batchFactory, 
            ShapeRendererFactoryInterface shapeRendererFactory, 
            StageFactoryInterface stageFactory,
            GameStateRenderer gameStateRenderer, 
            UpdateHandlerInterface updateHandler,
            GameState gameState,
            Game game
    ) {
        super(viewportFactory.create(), batchFactory.create(), shapeRendererFactory.create(), stageFactory.create(), null);

        this.game = game;
        this.gameState = gameState;
        this.gameStateRenderer = gameStateRenderer;
        this.updateHandler = updateHandler;
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam) {
        gameStateRenderer.render(batch, gameState);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, OrthographicCamera cam) {
        gameStateRenderer.render(shapeRenderer, gameState);
    }

    @Override
    public void update(double delta) {
        updateHandler.executeUpdates(delta);
    }

    @Override
    public void setupUI(Stage stage) {
        // TODO: setup game screen ui
    }

    @Override
    public Map<String, Class<?>> getAssetsToLoad() {
        // TODO: define assets to be loaded, preferably, create a new class that acts as a registry, 
        //  to avoid populating this class with a lot of code
        Map<String, Class<?>> assetsToLoad = new TreeMap<>();
        
        assetsToLoad.put("badlogic.jpg", Texture.class);
        
        return assetsToLoad;
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
        gameStateRenderer.initialize();
        updateHandler.start();
    }

    @Override
    public void hide() {
        super.hide();
        game.dispose();
        gameStateRenderer.dispose();
        updateHandler.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
        updateHandler.stop();
    }
}
