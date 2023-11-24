package com.codecool.passphrasechecker.service.aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateWordsAspectTest {

    private DuplicateWordsAspect duplicateWordsAspect;
    private boolean isValid;
    @BeforeEach
    void init() {
        duplicateWordsAspect = new DuplicateWordsAspect();
    }
    @Test
    void checkWithValidInputAndPunctuation() {
        String phrase = "alma korte.";
        isValid = duplicateWordsAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidInputAndPunctuation() {
        String phrase = "alma alma.";
        isValid = duplicateWordsAspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithValidInput() {
        String phrase = "alma korte";
        isValid = duplicateWordsAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidInput() {
        String phrase = "alma alma";
        isValid = duplicateWordsAspect.check(phrase);
        assertFalse(isValid);
    }
}