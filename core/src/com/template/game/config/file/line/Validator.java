package com.template.game.config.file.line;

public class Validator implements ValidatorInterface {

    @Override
    public boolean validate(String line, String delimiter) {
        if (line == null || line.isEmpty()) {
            return false;
        }

        if (!line.contains(delimiter)) {
            throw new RuntimeException("Invalid config detected: '" + line + "'");
        }

        String[] splitData = line.split(delimiter);

        if (splitData[0].trim().isEmpty()) {
            throw new RuntimeException("Invalid config detected: '" + line + "'");
        }

        return true;
    }
}
