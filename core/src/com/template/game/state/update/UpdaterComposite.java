package com.template.game.state.update;

import java.util.Map;

public class UpdaterComposite implements UpdaterInterface<Object>, UpdaterCheckerInterface {

    private Map<Class, UpdaterInterface<Object>> updaters;

    public UpdaterComposite(UpdaterProviderInterface updaterProvider) {
        updaters = updaterProvider.getUpdaters();
    }

    @Override
    public boolean hasUpdaterFor(Object object) {
        return updaters.containsKey(object.getClass());
    }

    @Override
    public void update(Object object, double delta) {
        updaters.get(object.getClass()).update(object.getClass().cast(object), delta);
    }
}
