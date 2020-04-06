package com.template.game.view.layout;

import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.view.TypeResolverInterface;
import com.template.game.view.component.ComponentFactoryInterface;
import com.template.game.view.layout.child.ChildrenAdderInterface;

public class LayoutFactory implements LayoutFactoryInterface {

    private TypeResolverInterface typeResolver;
    private ComponentFactoryInterface componentFactory;
    private ChildrenAdderInterface childrenAdder;

    public LayoutFactory(TypeResolverInterface typeResolver, ComponentFactoryInterface componentFactory, ChildrenAdderInterface childrenAdder) {
        this.typeResolver = typeResolver;
        this.componentFactory = componentFactory;
        this.childrenAdder = childrenAdder;
    }

    @Override
    public WidgetGroup create(NodeInterface layoutDescriptor) {
        String layoutType = layoutDescriptor.getValue("type");

        WidgetGroup layout = createLayout(layoutType);

        childrenAdder.add(layout, layoutDescriptor.getNode("children"), this, componentFactory);

        return layout;
    }

    private WidgetGroup createLayout(String type) {
        try {
            return (WidgetGroup) typeResolver.resolve(type).newInstance();
        } catch (IllegalAccessException | InstantiationException exception) {
            throw new RuntimeException(exception);
        }
    }
}
