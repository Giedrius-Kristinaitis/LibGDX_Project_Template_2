package com.gasis.template;

import com.gasis.di.registry.AbstractArgumentRegistry;
import com.gasis.template.config.ConfigValueProvider;
import com.gasis.template.io.file.converter.FileNameToInputStreamConverter;
import com.gasis.template.io.file.noded.Reader;

public class DependencyInjectionArgumentRegistry extends AbstractArgumentRegistry {

    @Override
    protected void initialize() {
        registerArgument(ConfigValueProvider.class, "configFileName", String.class, "config/application.conf");
        registerArgument(Reader.class, "inputConverter", Class.class, FileNameToInputStreamConverter.class);
    }
}
