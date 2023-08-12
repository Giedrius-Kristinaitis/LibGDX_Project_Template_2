package com.gasis.template;

import com.gasis.di.registry.AbstractPreferenceRegistry;
import com.gasis.template.config.ConfigValueProvider;
import com.gasis.template.config.ConfigValueProviderInterface;
import com.gasis.template.io.file.noded.Reader;
import com.gasis.template.io.file.noded.ReaderInterface;
import com.gasis.template.io.file.noded.node.Node;
import com.gasis.template.io.file.noded.node.NodeInterface;
import com.gasis.template.io.file.noded.node.ValueFinder;
import com.gasis.template.io.file.noded.node.ValueFinderInterface;
import com.gasis.template.state.GameState;
import com.gasis.template.state.update.updatehandler.UpdateHandler;
import com.gasis.template.state.update.updatehandler.UpdateHandlerInterface;
import com.gasis.undefined.GameStateInterface;
import com.gasis.undefined.RendererInterface;
import com.gasis.template.resources.ResourceManager;
import com.gasis.template.resources.ResourceManagerInterface;
import com.gasis.template.screen.batch.BatchFactoryInterface;
import com.gasis.template.screen.batch.SpriteBatchFactory;
import com.gasis.template.screen.shaperenderer.ShapeRendererFactory;
import com.gasis.template.screen.shaperenderer.ShapeRendererFactoryInterface;
import com.gasis.template.screen.stage.StageFactory;
import com.gasis.template.screen.stage.StageFactoryInterface;
import com.gasis.template.screen.viewport.StretchViewportFactory;
import com.gasis.template.screen.viewport.ViewportFactoryInterface;
import com.gasis.template.state.update.GameStateUpdater;
import com.gasis.template.state.update.GameStateUpdaterInterface;
import com.gasis.template.screen.*;
import com.gasis.template.state.render.RendererCheckerInterface;
import com.gasis.template.state.render.RendererComposite;
import com.gasis.template.state.render.RendererProviderInterface;

public class DependencyInjectionPreferenceRegistry extends AbstractPreferenceRegistry {

    @Override
    protected void initialize() {
        registerPreference(ResourceManagerInterface.class, ResourceManager.class);
        registerPreference(ScreenInterface.class, AbstractScreen.class);
        registerPreference(ScreenApplierInterface.class, GameApplication.class);
        registerPreference(ScreenDestroyerInterface.class, ScreenSwitcher.class);
        registerPreference(ScreenSwitcherInterface.class, ScreenSwitcher.class);
        registerPreference(ConfigValueProviderInterface.class, ConfigValueProvider.class);
        registerPreference(NodeInterface.class, Node.class);
        registerPreference(ValueFinderInterface.class, ValueFinder.class);
        registerPreference(ReaderInterface.class, Reader.class);
        registerPreference(RendererCheckerInterface.class, RendererComposite.class);
        registerPreference(RendererInterface.class, RendererComposite.class);
        registerPreference(RendererProviderInterface.class, RendererRegistry.class);
        registerPreference(GameStateUpdaterInterface.class, GameStateUpdater.class);
        registerPreference(ViewportFactoryInterface.class, StretchViewportFactory.class);
        registerPreference(BatchFactoryInterface.class, SpriteBatchFactory.class);
        registerPreference(StageFactoryInterface.class, StageFactory.class);
        registerPreference(ShapeRendererFactoryInterface.class, ShapeRendererFactory.class);
        registerPreference(UpdateHandlerInterface.class, UpdateHandler.class);
        registerPreference(GameStateInterface.class, GameState.class);
    }
}
