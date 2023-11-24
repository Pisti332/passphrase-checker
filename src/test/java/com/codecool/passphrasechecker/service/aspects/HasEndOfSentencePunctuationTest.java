package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class HasEndOfSentencePunctuationTest {
    private HasEndOfSentencePunctuation hasEndOfSentencePunctuation;
    private String phrase;
    private boolean isValid;

    @BeforeEach
    void init() {
        hasEndOfSentencePunctuation = new HasEndOfSentencePunctuation();
    }
    @Test
    void checkWithValidPhraseTest() {
        phrase = "korte alma!";
        isValid = hasEndOfSentencePunctuation.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidPhraseTest() {
        phrase = "korte alma";
        isValid = hasEndOfSentencePunctuation.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithInvalidPunctuationTest() {
        phrase = "korte alma%";
        isValid = hasEndOfSentencePunctuation.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithInvalidPunctuationOneWordTest() {
        phrase = "a%";
        isValid = hasEndOfSentencePunctuation.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithValidPunctuationOneWordTest() {
        phrase = "a.";
        isValid = hasEndOfSentencePunctuation.check(phrase);
        assertTrue(isValid);
    }
}