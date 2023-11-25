package com.codecool.passphrasechecker.service;

import com.codecool.passphrasechecker.service.aspects.MultipleWordsAspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private Validator validator;
    private List<Aspect> aspects;
    private final String VALID_PHRASE = "alma korte!";

    @BeforeEach
    void arrange() {
        aspects = new ArrayList<>();
        aspects.add(new MultipleWordsAspect());
        validator = new Validator(aspects);
    }

    @Test
    void validateWithValidPhraseTest() {
        boolean isValid = validator.validate(VALID_PHRASE);
        assertTrue(isValid);
    }
}