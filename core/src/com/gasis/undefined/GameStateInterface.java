package com.gasis.undefined;

public interface GameStateInterface {

    void insertUpdatable(UpdatableInterface updatable);

    void removeUpdatable(UpdatableInterface updatable);

    Iterable<UpdatableInterface> getUpdatables();

    void insertObjectToRender(Object object);

    void removeObjectToRender(Object object);

    Iterable<Object> getObjectsToRender();
    
    void clearUpdatables();
    
    void clearObjectsToRender();
}
