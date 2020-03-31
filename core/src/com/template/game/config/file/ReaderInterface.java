package com.template.game.config.file;

import com.template.game.config.node.NodeInterface;

public interface ReaderInterface {

    NodeInterface readFile(String file);
}
