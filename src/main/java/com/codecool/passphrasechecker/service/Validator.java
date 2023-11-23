package com.codecool.passphrasechecker.service;

import java.util.List;

public class Validator {
    public boolean validate(String phrase, List<Aspect> aspects) {
        for (Aspect aspect : aspects) {
            boolean isValid = aspect.check(phrase);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
