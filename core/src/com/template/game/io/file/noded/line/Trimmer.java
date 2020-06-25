package com.template.game.io.file.noded.line;

public class Trimmer {

    public String trim(String line, String commentSymbol) {
        String trimmed = line.trim();

        if (!trimmed.contains(commentSymbol)) {
            return trimmed;
        }

        int commendIndex = trimmed.indexOf(commentSymbol);

        return trimmed.substring(0, commendIndex).trim();
    }
}
