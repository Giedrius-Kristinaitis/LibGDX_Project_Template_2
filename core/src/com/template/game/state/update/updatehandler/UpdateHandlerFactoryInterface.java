package com.template.game.state.update.updatehandler;

import com.template.game.state.GameStateInterface;

public interface UpdateHandlerFactoryInterface {

    UpdateHandlerInterface create(GameStateInterface state);
}
