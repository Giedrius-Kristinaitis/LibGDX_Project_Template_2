package com.template.game.state;

public interface GameStateInterface {

    void insertObject(Object object);

    void removeObject(Object object);

    Iterable<Object> getObjects();

    Iterable<Object> getRenderables();
}
