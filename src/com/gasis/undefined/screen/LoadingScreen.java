package com.gasis.undefined.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.gasis.undefined.screen.config.LoadingScreenConfig;
import com.gasis.template.resources.ResourceManagerInterface;
import com.gasis.template.screen.AbstractScreen;
import com.gasis.template.screen.ScreenInterface;
import com.gasis.template.screen.ScreenSwitcherInterface;
import com.gasis.template.screen.batch.BatchFactoryInterface;
import com.gasis.template.screen.viewport.ViewportFactoryInterface;

import java.util.Map;

public class LoadingScreen extends AbstractScreen {

    private final LoadingScreenConfig loadingScreenConfig;
    private final ResourceManagerInterface resourceManager;
    private final ScreenSwitcherInterface screenSwitcher;
    private ScreenInterface screenToSwitchTo;
    private Texture splashImage;

    public LoadingScreen(ViewportFactoryInterface viewportFactory, BatchFactoryInterface batchFactory, LoadingScreenConfig loadingScreenConfig, ResourceManagerInterface resourceManager, ScreenSwitcherInterface screenSwitcher) {
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

        Map<String, Class<?>> assetsToLoad = screenToSwitchTo.getAssetsToLoad();

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
        
        if (!resourceManager.update()) {
            return;
        }

        resourceManager.unload(loadingScreenConfig.getSplashImageName());
        
        screenSwitcher.switchToScreen(screenToSwitchTo);
    }

    public void setScreenToSwitchTo(ScreenInterface screenToSwitchTo) {
        this.screenToSwitchTo = screenToSwitchTo;
    }
}
