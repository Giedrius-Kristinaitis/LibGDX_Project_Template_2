package com.gasis.template.config;

import com.gasis.di.annotation.Parameters;
import com.gasis.template.io.file.noded.ReaderInterface;
import com.gasis.template.io.file.noded.node.NodeInterface;
import com.gasis.template.io.file.noded.node.ValueFinderInterface;

public class ConfigValueProvider implements ConfigValueProviderInterface {

    private final String configFileName;
    private NodeInterface rootNode;
    private final ValueFinderInterface valueFinder;
    private final ReaderInterface inputReader;

    @Parameters({"configFileName", "fileReader", "valueFinder"})
    public ConfigValueProvider(String configFileName, ReaderInterface inputReader, ValueFinderInterface valueFinder) {
        this.configFileName = configFileName;
        this.valueFinder = valueFinder;
        this.inputReader = inputReader;
    }

    @Override
    public String getConfigValue(String path) {
        if (rootNode == null) {
            initialize();
        }

        String value = valueFinder.findValue(path, rootNode);

        if (value == null) {
            throw new RuntimeException("Config path '" + path + "' not found");
        }

        return value;
    }

    private void initialize() {
        rootNode = inputReader.read(configFileName);

        if (rootNode != null) {
            return;
        }

        throw new RuntimeException("Invalid config file structure");
    }
}
