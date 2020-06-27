package com.template.game.state;

import com.template.game.state.update.UpdatableInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentGameState extends AbstractGameState {

    @Override
    protected Map<Integer, UpdatableInterface> getMapForUpdatableObjects() {
        return new ConcurrentHashMap<Integer, UpdatableInterface>();
    }

    @Override
    protected Map<Integer, Object> getMapForObjectsToRender() {
        return new ConcurrentHashMap<Integer, Object>();
    }
}
