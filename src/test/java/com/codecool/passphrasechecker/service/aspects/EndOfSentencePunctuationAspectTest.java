package com.codecool.passphrasechecker.service.aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EndOfSentencePunctuationAspectTest {
    private EndOfSentencePunctuationAspect endOfSentencePunctuationAspect;
    private String phrase;
    private boolean isValid;

    @BeforeEach
    void arrange() {
        endOfSentencePunctuationAspect = new EndOfSentencePunctuationAspect();
    }
    @Test
    void checkWithValidPhraseTest() {
        phrase = "korte alma!";
        isValid = endOfSentencePunctuationAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidPhraseTest() {
        phrase = "korte alma";
        isValid = endOfSentencePunctuationAspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithInvalidPunctuationTest() {
        phrase = "korte alma%";
        isValid = endOfSentencePunctuationAspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithInvalidPunctuationOneWordTest() {
        phrase = "a%";
        isValid = endOfSentencePunctuationAspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithValidPunctuationOneWordTest() {
        phrase = "a.";
        isValid = endOfSentencePunctuationAspect.check(phrase);
        assertTrue(isValid);
    }
}