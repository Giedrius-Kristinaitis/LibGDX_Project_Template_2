package com.template.game.io.file.noded.line;

public class IndentationCalculator implements CalculatorInterface {

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
