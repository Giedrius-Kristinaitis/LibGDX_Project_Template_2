package com.template.game.state.update;

import java.util.Map;

public interface UpdaterProviderInterface {

    Map<Class, UpdaterInterface<Object>> getUpdaters();
}
