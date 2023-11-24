package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;
import com.codecool.passphrasechecker.service.aspects.utility.PunctuationRemover;

public class ContainsOnlyAlphabetsCharacters implements Aspect {
    private PunctuationRemover punctuationRemover;

    private final static String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public ContainsOnlyAlphabetsCharacters(PunctuationRemover punctuationRemover) {
        this.punctuationRemover = punctuationRemover;
    }

    @Override
    public boolean check(String phrase) {
        return checkIfOnlyAlphabetsCharacters(phrase);
    }
    private boolean checkIfOnlyAlphabetsCharacters(String phrase) {
        String[] words = phrase.split(" ");
        punctuationRemover.removePunctuation(words);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                boolean found = false;
                for (int j = 0; j < ENGLISH_ALPHABET.length(); j++) {
                    if (word.charAt(i) == ENGLISH_ALPHABET.charAt(j)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }
}
