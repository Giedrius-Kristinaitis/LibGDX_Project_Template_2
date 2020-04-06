package com.template.game.view.layout.child;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.view.TypeResolverInterface;
import com.template.game.view.component.ComponentFactoryInterface;
import com.template.game.view.layout.LayoutFactoryInterface;

import java.util.Map;

public class ChildrenAdder implements ChildrenAdderInterface {

    private TypeResolverInterface typeResolver;

    public ChildrenAdder(TypeResolverInterface typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Override
    public void add(WidgetGroup layout, NodeInterface childrenDescriptor, LayoutFactoryInterface layoutFactory, ComponentFactoryInterface componentFactory) {
        if (childrenDescriptor == null) {
            return;
        }

        for (Map.Entry<String, NodeInterface> child : childrenDescriptor.getNodes().entrySet()) {
            addChild(layout, child.getKey(), child.getValue(), layoutFactory, componentFactory);
        }
    }

    private void addChild(WidgetGroup layout, String childName, NodeInterface childDescriptor, LayoutFactoryInterface layoutFactory, ComponentFactoryInterface componentFactory) {
        Class<?> childType = typeResolver.resolve(childDescriptor.getValue("type"));

        Actor child = null;

        if (WidgetGroup.class.isAssignableFrom(childType)) {
            child = layoutFactory.create(childDescriptor);
        } else if (Widget.class.isAssignableFrom(childType)) {
            child = componentFactory.create(childDescriptor);
        } else {
            throw new RuntimeException("Found unsupported layout or component type");
        }

        child.setName(childName);
        layout.addActor(child);
    }
}
