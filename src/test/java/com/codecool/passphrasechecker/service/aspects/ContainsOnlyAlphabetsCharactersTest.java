package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.aspects.utility.PunctuationRemover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsOnlyAlphabetsCharactersTest {

    private ContainsOnlyAlphabetsCharacters containsOnlyAlphabetsCharacters;
    private boolean isValid;
    @BeforeEach
    void init() {
        containsOnlyAlphabetsCharacters = new ContainsOnlyAlphabetsCharacters(new PunctuationRemover());
    }
    @Test
    void checkWithValidCharacters() {
        String phrase = "alma";
        isValid = containsOnlyAlphabetsCharacters.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidCharacters() {
        String phrase = "banán";
        isValid = containsOnlyAlphabetsCharacters.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithValidCharactersAndPunctuation() {
        String phrase = "alma.";
        isValid = containsOnlyAlphabetsCharacters.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithValidCharactersAndMultipleWordsAndPunctuation() {
        String phrase = "korte alma!";
        isValid = containsOnlyAlphabetsCharacters.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidCharactersAndMultipleWordsAndPunctuation() {
        String phrase = "körte alma!";
        isValid = containsOnlyAlphabetsCharacters.check(phrase);
        assertFalse(isValid);
    }
}