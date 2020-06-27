package com.template.game.state;

import com.template.game.state.render.RendererCheckerInterface;

import java.util.HashMap;
import java.util.Map;

public class NonConcurrentGameState extends AbstractGameState {

    public NonConcurrentGameState(RendererCheckerInterface rendererChecker) {
        super(rendererChecker);
    }

    @Override
    protected Map<Integer, Object> getStateObjectsMap() {
        return new HashMap<Integer, Object>();
    }

    @Override
    protected Map<Integer, Object> getRenderablesMap() {
        return new HashMap<Integer, Object>();
    }
}
