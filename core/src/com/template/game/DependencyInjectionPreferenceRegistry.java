package com.template.game;

import com.di.registry.AbstractPreferenceRegistry;
import com.template.game.config.ConfigValueProvider;
import com.template.game.config.ConfigValueProviderInterface;
import com.template.game.io.file.noded.Reader;
import com.template.game.io.file.noded.ReaderInterface;
import com.template.game.io.file.noded.line.Trimmer;
import com.template.game.io.file.noded.line.TrimmerInterface;
import com.template.game.io.file.noded.line.Validator;
import com.template.game.io.file.noded.line.ValidatorInterface;
import com.template.game.io.file.noded.node.Node;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.io.file.noded.node.ValueFinder;
import com.template.game.io.file.noded.node.ValueFinderInterface;
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
import com.template.game.state.GameState;
import com.template.game.state.GameStateInterface;
import com.template.game.state.render.*;

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
        registerPreference(TrimmerInterface.class, Trimmer.class);
        registerPreference(ValidatorInterface.class, Validator.class);
        registerPreference(NodeInterface.class, Node.class);
        registerPreference(ReaderInterface.class, Reader.class);
        registerPreference(ValueFinderInterface.class, ValueFinder.class);
        registerPreference(RendererCheckerInterface.class, RendererComposite.class);
        registerPreference(RendererInterface.class, RendererComposite.class);
        registerPreference(RendererProviderInterface.class, RendererRegistry.class);
        registerPreference(GameStateInterface.class, GameState.class);
        registerPreference(BatchFactoryInterface.class, SpriteBatchFactory.class);
        registerPreference(ShapeRendererFactoryInterface.class, ShapeRendererFactory.class);
        registerPreference(StageFactoryInterface.class, StageFactory.class);
        registerPreference(ViewportFactoryInterface.class, FillViewportFactory.class);
        registerPreference(GameStateRendererInterface.class, GameStateRenderer.class);
    }
}
