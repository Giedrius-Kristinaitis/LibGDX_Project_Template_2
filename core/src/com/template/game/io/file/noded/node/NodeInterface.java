package com.template.game.io.file.noded.node;

public interface NodeInterface {

    boolean hasValues();

    boolean hasNodes();

    void addValue(String name, String value);

    void addNode(String name, NodeInterface node);

    String getValue(String name);

    NodeInterface getNode(String name);

    NodeInterface getParentNode();

    void setParentNode(NodeInterface parentNode);
}
