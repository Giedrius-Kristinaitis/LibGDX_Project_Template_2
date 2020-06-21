package com.template.game.state.update.updatehandler;

import com.di.ObjectManagerInterface;
import com.template.game.state.GameStateInterface;

public class UpdateHandlerFactory implements UpdateHandlerFactoryInterface {

    private UpdateHandlerConfigInterface config;

    private ObjectManagerInterface objectManager;

    public UpdateHandlerFactory(UpdateHandlerConfigInterface config, ObjectManagerInterface objectManager) {
        this.config = config;
        this.objectManager = objectManager;
    }

    @Override
    public UpdateHandlerInterface create(GameStateInterface state) {
        UpdateHandlerInterface handler = null;

        if (config.isUpdaterThreadEnabled()) {
            handler = (UpdateHandlerInterface) objectManager.instantiate(ThreadedUpdateHandler.class);
        } else {
            handler = (UpdateHandlerInterface) objectManager.instantiate(NonThreadedUpdateHandler.class);
        }

        handler.setGameState(state);

        return handler;
    }
}
