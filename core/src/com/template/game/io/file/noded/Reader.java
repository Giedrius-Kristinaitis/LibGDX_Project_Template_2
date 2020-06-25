package com.template.game.io.file.noded;

import com.di.annotation.Parameters;
import com.template.game.io.file.converter.ConverterInterface;
import com.template.game.io.file.noded.line.IndentationCalculator;
import com.template.game.io.file.noded.line.Trimmer;
import com.template.game.io.file.noded.line.Validator;
import com.template.game.io.file.noded.node.Node;
import com.template.game.io.file.noded.node.NodeInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader implements ReaderInterface {

    private static final String DELIMITER = ":";
    private static final String COMMENT_SYMBOL = "#";

    private IndentationCalculator indentationCalculator;
    private Validator validator;
    private ConverterInterface inputConverter;
    private Trimmer trimmer;

    @Parameters({"indentationCalculator", "validator", "inputConverter", "trimmer"})
    public Reader(IndentationCalculator indentationCalculator, Validator validator, ConverterInterface inputConverter, Trimmer trimmer) {
        this.indentationCalculator = indentationCalculator;
        this.validator = validator;
        this.inputConverter = inputConverter;
        this.trimmer = trimmer;
    }

    @Override
    public NodeInterface readFile(String file) {
        try {
            return getRootNode(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private NodeInterface getRootNode(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputConverter.convert(fileName)));
        NodeInterface root = new Node();
        NodeInterface currentNode = root;
        int previousIndentationLevel = 0;
        String line = null;

        while ((line = reader.readLine()) != null) {
            line = trimmer.trim(line, COMMENT_SYMBOL);

            if (!validator.validate(line, DELIMITER)) {
                continue;
            }

            int indentationLevel = indentationCalculator.getLineIndentationLevel(line);

            currentNode = getCurrentNodeFromIndentation(currentNode, previousIndentationLevel, indentationLevel);
            currentNode = modifyCurrentNode(currentNode, line);

            previousIndentationLevel = indentationLevel;
        }

        return root;
    }

    private NodeInterface getCurrentNodeFromIndentation(NodeInterface currentNode, int previousIndentationLevel, int indentationLevel) {
        int indentationDifference = indentationLevel - previousIndentationLevel;

        if (indentationDifference > 1) {
            throw new RuntimeException("Invalid config file line indentation detected");
        }

        if (indentationLevel == previousIndentationLevel || indentationDifference == 1) {
            return currentNode;
        }

        return getCurrentNodeFromIndentation(currentNode.getParentNode(), previousIndentationLevel - 1, indentationLevel);
    }

    private NodeInterface modifyCurrentNode(NodeInterface currentNode, String line) {
        String[] pathValue = line.split(DELIMITER);
        String path = pathValue[0];
        String value = pathValue[1];

        if (value == null || value.isEmpty()) {
            NodeInterface child = new Node();
            child.setParentNode(currentNode);
            currentNode.addNode(path, child);

            return child;
        } else {
            currentNode.addValue(path, value);

            return currentNode;
        }
    }
}
