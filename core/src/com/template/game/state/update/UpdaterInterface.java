package com.template.game.state.update;

public interface UpdaterInterface<T> {

    void update(T object, float delta);
}
