package com.template.game.resources;

/**
 * Custom exception class thrown when an asset is not loaded
 */
public class NotLoadedException extends RuntimeException {

    /**
     * @param message exception message
     */
    public NotLoadedException(String message) {
        super(message);
    }
}
