package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;

public class LowerCaseAspect implements Aspect {
    @Override
    public boolean check(String phrase) {
        return checkIfLowerCase(phrase);
    }
    private boolean checkIfLowerCase(String phrase) {
        String[] words = phrase.split(" ");
        for (String word : words) {
            if (!word.toLowerCase().equals(word)) {
                return false;
            }
        }
        return true;
    }
}
