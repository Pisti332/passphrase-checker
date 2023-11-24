package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;

public class HasEndOfSentencePunctuation implements Aspect {
    private static final String endOfSentencePunctuations = ".!?";
    @Override
    public boolean check(String phrase) {
        return checkIfHasEndOfSentencePunctuation(phrase);
    }
    private boolean checkIfHasEndOfSentencePunctuation(String phrase) {
        char endCharacter = phrase.charAt(phrase.length() - 1);
        for (int i = 0; i < endOfSentencePunctuations.length(); i++) {
            if (endCharacter == endOfSentencePunctuations.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
