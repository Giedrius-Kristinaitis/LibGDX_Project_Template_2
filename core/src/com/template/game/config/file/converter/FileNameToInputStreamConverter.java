package com.template.game.config.file.converter;

import com.badlogic.gdx.Gdx;

import java.io.InputStream;

public class FileNameToInputStreamConverter implements ConverterInterface {

    @Override
    public InputStream convert(String file) {
        return Gdx.files.internal(file).read();
    }
}
