package com.template.game.state.render;

import java.util.Map;

public interface RendererProviderInterface {

    Map<Class, RendererInterface<Object>> getRenderers();
}
