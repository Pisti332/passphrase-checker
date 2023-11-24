package com.codecool.passphrasechecker.service.aspects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseAspectTest {

    private boolean isValid;
    private LowerCaseAspect lowerCaseAspect;
    @BeforeEach
    void init() {
        lowerCaseAspect = new LowerCaseAspect();
    }
    @Test
    void checkWithValidPhraseTest() {
        String phrase = "alma korte.";
        isValid = lowerCaseAspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithInvalidPhraseTest() {
        String phrase = "alma kOrte.";
        isValid = lowerCaseAspect.check(phrase);
        assertFalse(isValid);
    }
}