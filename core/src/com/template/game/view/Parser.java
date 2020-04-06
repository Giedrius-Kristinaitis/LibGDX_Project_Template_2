package com.template.game.view;

import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.template.game.io.file.noded.ReaderInterface;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.view.layout.LayoutFactoryInterface;

public class Parser implements ParserInterface {

    private ReaderInterface fileReader;
    private LayoutFactoryInterface layoutFactory;

    public Parser(ReaderInterface fileReader, LayoutFactoryInterface layoutFactory) {
        this.fileReader = fileReader;
        this.layoutFactory = layoutFactory;
    }

    @Override
    public WidgetGroup parse(String viewFile) {
        NodeInterface rootNode = fileReader.readFile(viewFile);

        return layoutFactory.create(rootNode);
    }
}
