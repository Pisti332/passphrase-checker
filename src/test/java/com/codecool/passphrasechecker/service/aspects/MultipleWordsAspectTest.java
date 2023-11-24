package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleWordsAspectTest {
    private Aspect aspect;
    private String phrase;
    private boolean isValid;
    @BeforeEach
    void arrange() {
        aspect = new MultipleWordsAspect();
    }
    @Test
    void checkWithSimpleValidStringTest() {
        phrase = "korte alma mogyoro";
        isValid = aspect.check(phrase);
        assertTrue(isValid);
    }
    @Test
    void checkWithSimpleInvalidStringTest() {
        phrase = "korte";
        isValid = aspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithPrecedingSpaceTest() {
        phrase = " korte";
        isValid = aspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithPrecedingAndTrailingSpaceInvalidTest() {
        phrase = " korte ";
        isValid = aspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithPrecedingAndTrailingSpaceMultipleWordsTest() {
        phrase = " korte alma";
        isValid = aspect.check(phrase);
        assertFalse(isValid);
    }
    @Test
    void checkWithMultipleMiddleSpaceMultipleWordsTest() {
        phrase = "korte   alma";
        isValid = aspect.check(phrase);
        assertFalse(isValid);
    }
}