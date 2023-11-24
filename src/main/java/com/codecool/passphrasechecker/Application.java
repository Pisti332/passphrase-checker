package com.codecool.passphrasechecker;

import com.codecool.passphrasechecker.io.FileReader;
import com.codecool.passphrasechecker.io.TxtFileReader;
import com.codecool.passphrasechecker.service.Aspect;
import com.codecool.passphrasechecker.service.Validator;
import com.codecool.passphrasechecker.service.aspects.*;
import com.codecool.passphrasechecker.service.aspects.utility.PunctuationRemover;
import com.codecool.passphrasechecker.ui.ConsoleWriter;
import com.codecool.passphrasechecker.ui.ValueDisplay;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        FileReader fileReader = new TxtFileReader();
        String inputFilePath = "src/main/resources/input";
        ValueDisplay valueDisplay = new ConsoleWriter();
        List<Aspect> aspects = new ArrayList<>();
        aspects.add(new MultipleWordsAspect());
        aspects.add(new HasEndOfSentencePunctuation());
        aspects.add(new DuplicateWordsAspect(new PunctuationRemover()));
        aspects.add(new ContainsOnlyAlphabetsCharacters(new PunctuationRemover()));
        aspects.add(new LowerCaseAspect());
        Validator validator = new Validator(aspects);
        PassphraseChecker passphraseChecker = new PassphraseChecker(fileReader, inputFilePath, valueDisplay, validator);

        passphraseChecker.run();
    }
}
