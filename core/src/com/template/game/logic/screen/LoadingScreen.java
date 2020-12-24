package com.template.game.logic.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.template.game.logic.screen.config.LoadingScreenConfigInterface;
import com.template.game.resources.ResourceManagerInterface;
import com.template.game.screen.AbstractScreen;
import com.template.game.screen.ScreenInterface;
import com.template.game.screen.ScreenSwitcherInterface;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.viewport.ViewportFactoryInterface;

import java.util.Map;

public class LoadingScreen extends AbstractScreen {

    private LoadingScreenConfigInterface loadingScreenConfig;
    private ResourceManagerInterface resourceManager;
    private ScreenSwitcherInterface screenSwitcher;
    private ScreenInterface screenToSwitchTo;
    private Texture splashImage;

    public LoadingScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory, LoadingScreenConfigInterface loadingScreenConfig, ResourceManagerInterface resourceManager, ScreenSwitcherInterface screenSwitcher) {
        super(viewportFactory.create(), batchFactory.create(), null, null, null);

        this.loadingScreenConfig = loadingScreenConfig;
        this.resourceManager = resourceManager;
        this.screenSwitcher = screenSwitcher;
    }

    @Override
    public void show() {
        super.show();

        resourceManager.load(loadingScreenConfig.getSplashImageName(), Texture.class);
        resourceManager.finishLoading();

        splashImage = resourceManager.texture(loadingScreenConfig.getSplashImageName());

        Map<String, Class> assetsToLoad = screenToSwitchTo.getAssetsToLoad();

        if (assetsToLoad == null) {
            return;
        }

        resourceManager.load(assetsToLoad);
    }

    @Override
    public void draw(Batch batch, OrthographicCamera cam) {
        batch.draw(splashImage, 0, 0, getViewport().getWorldWidth(), getViewport().getWorldHeight());
    }

    @Override
    public void update(double delta) {
        super.update(delta);

        resourceManager.update();

        if (resourceManager.getProgress() < 1f) {
            return;
        }

        resourceManager.unload(loadingScreenConfig.getSplashImageName(), Texture.class);

        screenSwitcher.switchScreen(screenToSwitchTo);
    }

    public void setScreenToSwitchTo(ScreenInterface screenToSwitchTo) {
        this.screenToSwitchTo = screenToSwitchTo;
    }
}
