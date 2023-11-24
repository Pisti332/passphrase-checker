package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.model.EndOfSentencePunctuations;
import com.codecool.passphrasechecker.service.Aspect;

public class HasEndOfSentencePunctuation implements Aspect {
    @Override
    public boolean check(String phrase) {
        return checkIfHasEndOfSentencePunctuation(phrase);
    }
    private boolean checkIfHasEndOfSentencePunctuation(String phrase) {
        char endCharacter = phrase.charAt(phrase.length() - 1);
        for (EndOfSentencePunctuations endOfSentencePunctuations : EndOfSentencePunctuations.values()) {
            if (endCharacter == endOfSentencePunctuations.getValue()) {
                return true;
            }
        }
        return false;
    }
}
