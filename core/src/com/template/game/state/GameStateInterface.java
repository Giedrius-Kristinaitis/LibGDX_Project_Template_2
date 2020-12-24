package com.template.game.state;

import com.template.game.state.update.UpdatableInterface;

public interface GameStateInterface {

    void insertUpdatable(UpdatableInterface updatable);

    void removeUpdatable(UpdatableInterface updatable);

    Iterable<UpdatableInterface> getUpdatables();

    void insertObjectToRender(Object object);

    void removeObjectToRender(Object object);

    void clearObjectsToRender();

    Iterable<Object> getObjectsToRender();
}
