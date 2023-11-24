package com.codecool.passphrasechecker.service.aspects.utility;

import com.codecool.passphrasechecker.model.EndOfSentencePunctuations;

public class PunctuationRemover {
    public void removePunctuation(String[] words) {
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
