package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.model.EndOfSentencePunctuations;
import com.codecool.passphrasechecker.service.Aspect;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWordsAspect implements Aspect {
    @Override
    public boolean check(String phrase) {
        return checkIfOnlyUniqueWords(phrase);
    }

    private boolean checkIfOnlyUniqueWords(String phrase) {
        String[] words = phrase.split(" ");
        removePunctuation(words);
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
    private void removePunctuation(String[] words) {
        String lastWord = words[words.length - 1];
        char lastChar = lastWord.charAt(lastWord.length() - 1);
        for (EndOfSentencePunctuations punctuation : EndOfSentencePunctuations.values()) {
            if (punctuation.getValue() == lastChar) {
                words[words.length - 1] = lastWord.substring(0, lastWord.length() - 1);
                break;
            }
        }
    }
}
