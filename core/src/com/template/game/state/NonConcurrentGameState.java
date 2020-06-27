package com.template.game.state;

import com.template.game.state.update.UpdatableInterface;

import java.util.HashMap;
import java.util.Map;

public class NonConcurrentGameState extends AbstractGameState {

    @Override
    protected Map<Integer, UpdatableInterface> getMapForUpdatableObjects() {
        return new HashMap<Integer, UpdatableInterface>();
    }

    @Override
    protected Map<Integer, Object> getMapForObjectsToRender() {
        return new HashMap<Integer, Object>();
    }
}
