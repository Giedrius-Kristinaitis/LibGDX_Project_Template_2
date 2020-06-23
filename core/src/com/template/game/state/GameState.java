package com.template.game.state;

import com.template.game.state.render.RendererCheckerInterface;

import java.util.HashMap;
import java.util.Map;

public class GameState implements GameStateInterface {

    private final Map<Integer, Object> stateObjects = new HashMap<Integer, Object>();
    private final Map<Integer, Object> renderables = new HashMap<Integer, Object>();
    private RendererCheckerInterface rendererChecker;

    public GameState(RendererCheckerInterface rendererChecker) {
        this.rendererChecker = rendererChecker;
    }

    @Override
    public void insertObject(Object object) {
        synchronized (this) {
            stateObjects.put(object.hashCode(), object);

            if (!rendererChecker.hasRendererFor(object)) {
                return;
            }

            renderables.put(object.hashCode(), object);
        }
    }

    @Override
    public void removeObject(Object object) {
        synchronized (this) {
            stateObjects.remove(object.hashCode());
            renderables.remove(object.hashCode());
        }
    }

    @Override
    public Iterable<Object> getObjects() {
        synchronized (this) {
            return stateObjects.values();
        }
    }

    @Override
    public Iterable<Object> getRenderables() {
        synchronized (this) {
            return renderables.values();
        }
    }
}
