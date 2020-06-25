package com.template.game.config;

import com.di.annotation.Parameters;
import com.template.game.io.file.noded.ReaderInterface;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.io.file.noded.node.ValueFinderInterface;

public class ConfigValueProvider implements ConfigValueProviderInterface {

    private String configFileName;
    private NodeInterface rootNode;
    private ValueFinderInterface valueFinder;
    private ReaderInterface inputReader;

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
