package com.template.game;

import com.badlogic.gdx.utils.Disposable;
import com.template.game.screen.ScreenApplierInterface;

public interface GameInterface extends Disposable {

    void setScreenApplier(ScreenApplierInterface applier);
}
