package com.template.game.view;

import com.badlogic.gdx.scenes.scene2d.ui.*;

public class TypeResolver implements TypeResolverInterface {

    @Override
    public Class<?> resolve(String viewType) {
        switch (viewType) {
            case "HorizontalGroup":
                return HorizontalGroup.class;
            case "VerticalGroup":
                return VerticalGroup.class;
            case "Table":
                return Table.class;
            case "ScrollPane":
                return ScrollPane.class;
            case "Dialog":
                return Dialog.class;
            case "Button":
                return Button.class;
            case "TextButton":
                return TextButton.class;
            case "ImageButton":
                return ImageButton.class;
            case "Label":
                return Label.class;
            case "Checkbox":
                return CheckBox.class;
            default:
                return null;
        }
    }
}
