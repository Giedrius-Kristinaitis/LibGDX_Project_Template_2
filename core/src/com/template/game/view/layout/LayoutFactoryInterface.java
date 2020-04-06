package com.template.game.view.layout;

import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.node.NodeInterface;

public interface LayoutFactoryInterface {

    WidgetGroup create(NodeInterface rootNode);
}
