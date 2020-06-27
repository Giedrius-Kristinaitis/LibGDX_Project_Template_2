package com.template.game.state;

import com.template.game.state.render.RendererCheckerInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentGameState extends AbstractGameState {

    public ConcurrentGameState(RendererCheckerInterface rendererChecker) {
        super(rendererChecker);
    }

    @Override
    protected Map<Integer, Object> getStateObjectsMap() {
        return new ConcurrentHashMap<Integer, Object>();
    }

    @Override
    protected Map<Integer, Object> getRenderablesMap() {
        return new ConcurrentHashMap<Integer, Object>();
    }
}
