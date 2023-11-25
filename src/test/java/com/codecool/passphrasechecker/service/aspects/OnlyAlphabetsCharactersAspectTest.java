package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.aspects.utility.PunctuationRemover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlyAlphabetsCharactersAspectTest {

    private OnlyAlphabetsCharactersAspect onlyAlphabetsCharactersAspect;
    private boolean isValid;
    @BeforeEach
    void init() {
        onlyAlphabetsCharactersAspect = new OnlyAlphabetsCharactersAspect(new PunctuationRemover());
    }
    @Test
    void checkWithValidCharacters() {
        String phrase = "alma";
        isValid = onlyAlphabetsCharactersAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidCharacters() {
        String phrase = "banán";
        isValid = onlyAlphabetsCharactersAspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithValidCharactersAndPunctuation() {
        String phrase = "alma.";
        isValid = onlyAlphabetsCharactersAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithValidCharactersAndMultipleWordsAndPunctuation() {
        String phrase = "korte alma!";
        isValid = onlyAlphabetsCharactersAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidCharactersAndMultipleWordsAndPunctuation() {
        String phrase = "körte alma!";
        isValid = onlyAlphabetsCharactersAspect.check(phrase);
        assertFalse(isValid);
    }
}