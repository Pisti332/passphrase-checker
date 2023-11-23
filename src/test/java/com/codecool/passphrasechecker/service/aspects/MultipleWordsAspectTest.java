package com.codecool.passphrasechecker.service.aspects;

import com.codecool.passphrasechecker.service.Aspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleWordsAspectTest {
    private Aspect aspect;
    @BeforeEach
    void arrange() {
        aspect = new MultipleWordsAspect();
    }
    @Test
    void checkWithSimpleValidStringTest() {
        String phrase = "korte alma mogyoro";
        assertTrue(aspect.check(phrase));
    }
    @Test
    void checkWithSimpleInvalidStringTest() {
        String phrase = "korte";
        assertFalse(aspect.check(phrase));
    }
    @Test
    void checkWithPrecedingSpaceTest() {
        String phrase = " korte";
        assertFalse(aspect.check(phrase));
    }
    @Test
    void checkWithPrecedingAndTrailingSpaceInvalidTest() {
        String phrase = " korte ";
        assertFalse(aspect.check(phrase));
    }
    @Test
    void checkWithPrecedingAndTrailingSpaceMultipleWordsTest() {
        String phrase = " korte alma";
        assertFalse(aspect.check(phrase));
    }
    @Test
    void checkWithMultipleMiddleSpaceMultipleWordsTest() {
        String phrase = "korte   alma";
        assertFalse(aspect.check(phrase));
    }
}