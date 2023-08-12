package com.gasis.template.state.render;

import com.gasis.undefined.RendererInterface;

import java.util.Map;

public interface RendererProviderInterface {

    Map<Class<?>, RendererInterface<Object>> getRenderers();
}
