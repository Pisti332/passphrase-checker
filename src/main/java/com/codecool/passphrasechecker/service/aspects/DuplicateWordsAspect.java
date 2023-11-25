package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;
import com.codecool.passphrasechecker.service.aspects.utility.PunctuationRemover;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWordsAspect implements Aspect {
    private PunctuationRemover punctuationRemover;

    public DuplicateWordsAspect(PunctuationRemover punctuationRemover) {
        this.punctuationRemover = punctuationRemover;
    }

    @Override
    public boolean check(String phrase) {
        return checkIfOnlyUniqueWords(phrase);
    }

    private boolean checkIfOnlyUniqueWords(String phrase) {
        String[] words = phrase.split(" ");
        punctuationRemover.removePunctuation(words);
        Map<String, Integer> wordsAppearance = new HashMap<>();
        for (String word : words) {
            if (wordsAppearance.get(word) != null) {
                return false;
            }
            else {
                wordsAppearance.put(word, 1);
            }
        }
        return true;
    }
}
