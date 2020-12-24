package com.template.game;

import com.badlogic.gdx.utils.Disposable;
import com.template.game.screen.ScreenApplierInterface;
import com.template.game.screen.ScreenDestroyerInterface;

public interface GameInterface extends Disposable {

    void setScreenApplier(ScreenApplierInterface applier);

    void setScreenDestroyer(ScreenDestroyerInterface screenDestroyer);
}
