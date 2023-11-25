package com.codecool.passphrasechecker;

import com.codecool.passphrasechecker.io.FileReader;
import com.codecool.passphrasechecker.service.Validator;
import com.codecool.passphrasechecker.ui.ValueDisplay;

import java.util.List;

public class PassphraseChecker {
    private final FileReader fileReader;
    private final ValueDisplay valueDisplay;
    private final String inputFilePath;
    private final Validator validator;

    public PassphraseChecker(FileReader fileReader,
                             String inputFilePath,
                             ValueDisplay valueDisplay,
                             Validator validator) {
        this.fileReader = fileReader;
        this.valueDisplay = valueDisplay;
        this.inputFilePath = inputFilePath;
        this.validator = validator;
    }

    public void run() {
        try {
            int validLineCount = 0;
            List<String> lines = this.fileReader.readByLines(this.inputFilePath);
            for (String line : lines) {
                boolean isLineValid = validator.validate(line);
                if (isLineValid) {
                    validLineCount++;
                }
            }
            valueDisplay.showNumberOfValidPhrases(validLineCount);
        }
        catch (Exception e) {
            valueDisplay.showGeneralError();
        }

    }
}
