package com.template.game.state;

import com.template.game.state.render.RendererCheckerInterface;

import java.util.Map;

public abstract class AbstractGameState implements GameStateInterface {

    private Map<Integer, Object> stateObjects;
    private Map<Integer, Object> renderables;
    private RendererCheckerInterface rendererChecker;

    public AbstractGameState(RendererCheckerInterface rendererChecker) {
        this.rendererChecker = rendererChecker;

        stateObjects = getStateObjectsMap();
        renderables = getRenderablesMap();
    }

    @Override
    public void insertObject(Object object) {
        stateObjects.put(object.hashCode(), object);

        if (!rendererChecker.hasRendererFor(object)) {
            return;
        }

        renderables.put(object.hashCode(), object);
    }

    @Override
    public void removeObject(Object object) {
        stateObjects.remove(object.hashCode());
        renderables.remove(object.hashCode());
    }

    @Override
    public Iterable<Object> getObjects() {
        return stateObjects.values();
    }

    @Override
    public Iterable<Object> getRenderables() {
        return renderables.values();
    }

    protected abstract Map<Integer, Object> getStateObjectsMap();

    protected abstract Map<Integer, Object> getRenderablesMap();
}
