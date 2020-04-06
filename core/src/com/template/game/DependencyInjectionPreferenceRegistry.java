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
import com.template.game.view.Parser;
import com.template.game.view.ParserInterface;
import com.template.game.view.TypeResolver;
import com.template.game.view.TypeResolverInterface;
import com.template.game.view.component.ComponentFactory;
import com.template.game.view.component.ComponentFactoryInterface;
import com.template.game.view.layout.LayoutFactory;
import com.template.game.view.layout.LayoutFactoryInterface;
import com.template.game.view.layout.child.ChildrenAdder;
import com.template.game.view.layout.child.ChildrenAdderInterface;

public class DependencyInjectionPreferenceRegistry extends AbstractPreferenceRegistry {

    @Override
    protected void initialize() {
        registerPreference(ResourceManagerInterface.class, ResourceManager.class);
        registerPreference(GameInterface.class, Game.class);
        registerPreference(ScreenInterface.class, Screen.class);
        registerPreference(ScreenApplierInterface.class, Game.class);
        registerPreference(ScreenDestroyerInterface.class, ScreenSwitcher.class);
        registerPreference(ScreenSwitcherInterface.class, ScreenSwitcher.class);
        registerPreference(ConfigValueProviderInterface.class, ConfigValueProvider.class);
        registerPreference(TrimmerInterface.class, Trimmer.class);
        registerPreference(ValidatorInterface.class, Validator.class);
        registerPreference(NodeInterface.class, Node.class);
        registerPreference(ReaderInterface.class, Reader.class);
        registerPreference(ValueFinderInterface.class, ValueFinder.class);
        registerPreference(ParserInterface.class, Parser.class);
        registerPreference(ComponentFactoryInterface.class, ComponentFactory.class);
        registerPreference(LayoutFactoryInterface.class, LayoutFactory.class);
        registerPreference(TypeResolverInterface.class, TypeResolver.class);
        registerPreference(ChildrenAdderInterface.class, ChildrenAdder.class);
    }
}
