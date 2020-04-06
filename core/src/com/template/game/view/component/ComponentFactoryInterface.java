package com.template.game.view.component;

import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.template.game.io.file.noded.node.NodeInterface;

public interface ComponentFactoryInterface {

    Widget create(NodeInterface componentDescriptor);
}
