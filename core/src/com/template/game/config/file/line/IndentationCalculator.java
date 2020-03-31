package com.template.game.config.file.line;

public class IndentationCalculator implements IndentationCalculatorInterface {

    @Override
    public int getLineIndentationLevel(String line) {
        int spaceCount = 0;

        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                spaceCount++;
            } else if (character == '\t') {
                spaceCount += 4;
            } else {
                break;
            }
        }

        return spaceCount / 4;
    }
}
