package com.template.game;

import com.di.registry.AbstractPreferenceRegistry;
import com.template.game.config.ConfigValueProvider;
import com.template.game.config.ConfigValueProviderInterface;
import com.template.game.io.file.noded.Reader;
import com.template.game.io.file.noded.ReaderInterface;
import com.template.game.io.file.noded.node.Node;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.io.file.noded.node.ValueFinder;
import com.template.game.io.file.noded.node.ValueFinderInterface;
import com.template.game.logic.WorldConfig;
import com.template.game.logic.WorldConfigInterface;
import com.template.game.resources.ResourceManager;
import com.template.game.resources.ResourceManagerInterface;
import com.template.game.screen.*;
import com.template.game.screen.batch.BatchFactoryInterface;
import com.template.game.screen.batch.SpriteBatchFactory;
import com.template.game.screen.shaperenderer.ShapeRendererFactory;
import com.template.game.screen.shaperenderer.ShapeRendererFactoryInterface;
import com.template.game.screen.stage.StageFactory;
import com.template.game.screen.stage.StageFactoryInterface;
import com.template.game.screen.viewport.FillViewportFactory;
import com.template.game.screen.viewport.ViewportFactoryInterface;
import com.template.game.state.GameStateProvider;
import com.template.game.state.GameStateProviderInterface;
import com.template.game.state.render.*;
import com.template.game.state.update.*;
import com.template.game.state.update.updatehandler.UpdateHandlerConfig;
import com.template.game.state.update.updatehandler.UpdateHandlerConfigInterface;
import com.template.game.state.update.updatehandler.UpdateHandlerFactory;
import com.template.game.state.update.updatehandler.UpdateHandlerFactoryInterface;
import com.template.game.state.update.updatehandler.threading.MainThreadRunnableQueue;
import com.template.game.state.update.updatehandler.threading.MainThreadRunnableQueueInterface;

public class DependencyInjectionPreferenceRegistry extends AbstractPreferenceRegistry {

    @Override
    protected void initialize() {
        registerPreference(ResourceManagerInterface.class, ResourceManager.class);
        registerPreference(GameInterface.class, Game.class);
        registerPreference(ScreenInterface.class, AbstractScreen.class);
        registerPreference(ScreenApplierInterface.class, Game.class);
        registerPreference(ScreenDestroyerInterface.class, ScreenSwitcher.class);
        registerPreference(ScreenSwitcherInterface.class, ScreenSwitcher.class);
        registerPreference(ConfigValueProviderInterface.class, ConfigValueProvider.class);
        registerPreference(NodeInterface.class, Node.class);
        registerPreference(ValueFinderInterface.class, ValueFinder.class);
        registerPreference(ReaderInterface.class, Reader.class);
        registerPreference(RendererCheckerInterface.class, RendererComposite.class);
        registerPreference(RendererInterface.class, RendererComposite.class);
        registerPreference(RendererProviderInterface.class, RendererRegistry.class);
        registerPreference(BatchFactoryInterface.class, SpriteBatchFactory.class);
        registerPreference(ShapeRendererFactoryInterface.class, ShapeRendererFactory.class);
        registerPreference(StageFactoryInterface.class, StageFactory.class);
        registerPreference(ViewportFactoryInterface.class, FillViewportFactory.class);
        registerPreference(GameStateRendererInterface.class, GameStateRenderer.class);
        registerPreference(UpdaterCheckerInterface.class, UpdaterComposite.class);
        registerPreference(UpdaterInterface.class, UpdaterComposite.class);
        registerPreference(UpdaterProviderInterface.class, UpdaterRegistry.class);
        registerPreference(GameStateUpdaterInterface.class, GameStateUpdater.class);
        registerPreference(UpdateHandlerFactoryInterface.class, UpdateHandlerFactory.class);
        registerPreference(UpdateHandlerConfigInterface.class, UpdateHandlerConfig.class);
        registerPreference(PerformanceConfigInterface.class, PerformanceConfig.class);
        registerPreference(MainThreadRunnableQueueInterface.class, MainThreadRunnableQueue.class);
        registerPreference(WorldConfigInterface.class, WorldConfig.class);
        registerPreference(GameStateProviderInterface.class, GameStateProvider.class);
    }
}
