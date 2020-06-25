package com.template.game.config;

import com.di.annotation.Parameters;
import com.template.game.io.file.noded.ReaderInterface;
import com.template.game.io.file.noded.node.NodeInterface;
import com.template.game.io.file.noded.node.ValueFinderInterface;

public class ConfigValueProvider implements ConfigValueProviderInterface {

    private NodeInterface rootNode;
    private ValueFinderInterface valueFinder;

    @Parameters({"configFileName", "fileReader", "valueFinder"})
    public ConfigValueProvider(String configFileName, ReaderInterface fileReader, ValueFinderInterface valueFinder) {
        this.valueFinder = valueFinder;

        initialize(configFileName, fileReader);
    }

    @Override
    public String getConfigValue(String path) {
        if (rootNode == null) {
            return null;
        }

        String value = valueFinder.findValue(path, rootNode);

        if (value == null) {
            throw new RuntimeException("Config path '" + path + "' not found");
        }

        return value;
    }

    private void initialize(String fileName, ReaderInterface fileReader) {
        rootNode = fileReader.readFile(fileName);
    }
}
