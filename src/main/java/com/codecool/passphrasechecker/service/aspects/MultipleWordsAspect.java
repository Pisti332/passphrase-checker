package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;

public class MultipleWordsAspect implements Aspect {
    @Override
    public boolean check(String phrase) {
        return checkIfThereAreMultipleWords(phrase);
    }

    private boolean checkIfThereAreMultipleWords(String phrase) {
        String[] parts = phrase.split(" ");
        for (String part : parts) {
            if (part.length() == 0) {
                return false;
            }
        }
        return parts.length > 1;
    }
}
