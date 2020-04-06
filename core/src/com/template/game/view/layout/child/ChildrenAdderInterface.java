package com.template.game.view.layout.child;

import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.view.component.ComponentFactoryInterface;
import com.template.game.view.layout.LayoutFactoryInterface;

public interface ChildrenAdderInterface {

    void add(WidgetGroup layout, NodeInterface childrenDescriptor, LayoutFactoryInterface layoutFactory, ComponentFactoryInterface componentFactory);
}
