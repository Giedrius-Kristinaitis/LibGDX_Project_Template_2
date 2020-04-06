package com.template.game.view.layout;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.view.TypeResolverInterface;
import com.template.game.view.component.ComponentFactory;
import com.template.game.view.component.ComponentFactoryInterface;

import java.util.Map;

public class LayoutFactory implements LayoutFactoryInterface {

    private TypeResolverInterface typeResolver;
    private ComponentFactoryInterface componentFactory;

    public LayoutFactory(TypeResolverInterface typeResolver, ComponentFactory componentFactory) {
        this.typeResolver = typeResolver;
        this.componentFactory = componentFactory;
    }

    @Override
    public WidgetGroup create(NodeInterface layoutDescriptor) {
        String layoutType = layoutDescriptor.getValue("type");

        WidgetGroup layout = createLayout(layoutType);

        addChildren(layout, layoutDescriptor.getNode("children"));

        return layout;
    }

    private void addChildren(WidgetGroup layout, NodeInterface childrenDescriptor) {
        if (childrenDescriptor == null) {
            return;
        }

        for (Map.Entry<String, NodeInterface> child : childrenDescriptor.getNodes().entrySet()) {
            addChild(layout, child.getKey(), child.getValue());
        }
    }

    private void addChild(WidgetGroup layout, String childName, NodeInterface childDescriptor) {
        Class<?> childType = typeResolver.resolve(childDescriptor.getValue("type"));

        Actor child = null;

        if (Widget.class.isAssignableFrom(childType)) {
            child = create(childDescriptor);
        } else if (WidgetGroup.class.isAssignableFrom(childType)) {
            child = componentFactory.create(childDescriptor);
        } else {
            throw new RuntimeException("Found unsupported layout or component type");
        }

        child.setName(childName);
        layout.addActor(child);
    }

    private WidgetGroup createLayout(String type) {
        try {
            return (WidgetGroup) typeResolver.resolve(type).newInstance();
        } catch (IllegalAccessException | InstantiationException exception) {
            throw new RuntimeException(exception);
        }
    }
}
