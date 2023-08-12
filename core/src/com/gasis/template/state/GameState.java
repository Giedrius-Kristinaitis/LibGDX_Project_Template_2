package com.gasis.template.state;

import com.gasis.undefined.GameStateInterface;
import com.gasis.undefined.UpdatableInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameState implements GameStateInterface {

    private final Map<Integer, UpdatableInterface> updatables;
    private final Map<Integer, Object> objectsToRender;
    
    /** 
     * these caches are created for performance reasons so that
     * it wouldn't create collections from hash maps on every single
     * frame, it will be done only when hash maps actually change,
     * which is gonna happen a lot less often than on every single frame
     */
    private Collection<UpdatableInterface> updatableCache;
    private Collection<Object> renderableCache;

    public GameState() {
        updatables = new HashMap<>();
        objectsToRender = new HashMap<>();
        
        updatableCache = Collections.emptyList();
        renderableCache = Collections.emptyList();
    }
    
    @Override
    public void insertUpdatable(UpdatableInterface updatable) {
        updatables.put(updatable.hashCode(), updatable);
        
        updatableCache = updatables.values();
    }
    
    @Override
    public void removeUpdatable(UpdatableInterface updatable) {
        updatables.remove(updatable.hashCode());
        
        updatableCache = updatables.values();
    }

    @Override
    public Iterable<UpdatableInterface> getUpdatables() {
        return updatableCache;
    }

    @Override
    public void insertObjectToRender(Object object) {
        objectsToRender.put(object.hashCode(), object);
        
        renderableCache = objectsToRender.values();
    }

    @Override
    public void removeObjectToRender(Object object) {
        objectsToRender.remove(object.hashCode());
        
        renderableCache = objectsToRender.values();
    }

    @Override
    public Iterable<Object> getObjectsToRender() {
        return renderableCache;
    }

    @Override
    public void clearUpdatables() {
        updatables.clear();
        
        updatableCache = Collections.emptyList();
    }

    @Override
    public void clearObjectsToRender() {
        objectsToRender.clear();
        
        renderableCache = Collections.emptyList();
    }
}
