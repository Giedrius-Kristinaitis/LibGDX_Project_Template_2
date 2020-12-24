package com.template.game.state;

import com.template.game.state.update.UpdatableInterface;

import java.util.Map;

public abstract class AbstractGameState implements GameStateInterface {

    private Map<Integer, UpdatableInterface> updatables;
    private Map<Integer, Object> objectsToRender;

    public AbstractGameState() {
        updatables = getMapForUpdatableObjects();
        objectsToRender = getMapForObjectsToRender();
    }

    @Override
    public void insertUpdatable(UpdatableInterface updatable) {
        updatables.put(updatable.hashCode(), updatable);
    }

    @Override
    public void removeUpdatable(UpdatableInterface updatable) {
        updatables.remove(updatable.hashCode());
    }

    @Override
    public Iterable<UpdatableInterface> getUpdatables() {
        return updatables.values();
    }

    @Override
    public void insertObjectToRender(Object object) {
        objectsToRender.put(object.hashCode(), object);
    }

    @Override
    public void removeObjectToRender(Object object) {
        objectsToRender.remove(object.hashCode());
    }

    @Override
    public void clearObjectsToRender() {
        objectsToRender.clear();
    }

    @Override
    public Iterable<Object> getObjectsToRender() {
        return objectsToRender.values();
    }

    protected abstract Map<Integer, UpdatableInterface> getMapForUpdatableObjects();

    protected abstract Map<Integer, Object> getMapForObjectsToRender();
}
