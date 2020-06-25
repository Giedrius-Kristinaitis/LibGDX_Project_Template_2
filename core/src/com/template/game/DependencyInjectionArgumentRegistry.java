package com.template.game;

import com.di.registry.AbstractArgumentRegistry;
import com.template.game.config.ConfigValueProvider;
import com.template.game.io.file.converter.FileNameToInputStreamConverter;
import com.template.game.io.file.noded.Reader;

public class DependencyInjectionArgumentRegistry extends AbstractArgumentRegistry {

    @Override
    protected void initialize() {
        registerArgument(ConfigValueProvider.class, "configFileName", String.class, "config/application.config");
        registerArgument(Reader.class, "inputConverter", Class.class, FileNameToInputStreamConverter.class);
    }
}
