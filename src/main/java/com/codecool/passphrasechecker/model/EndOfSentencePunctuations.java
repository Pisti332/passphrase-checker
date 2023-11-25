package com.codecool.passphrasechecker.model;

public enum EndOfSentencePunctuations {
    DOT('.'),
    QUESTION_MARK('?'),
    EXCLAMATION_MARK('!');
    private final char value;

    EndOfSentencePunctuations(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
