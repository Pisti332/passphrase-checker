package com.codecool.passphrasechecker.service;

import java.util.List;

public class Validator {
    private List<Aspect> aspects;

    public Validator(List<Aspect> aspects) {
        this.aspects = aspects;
    }

    public boolean validate(String phrase) {
        for (Aspect aspect : this.aspects) {
            boolean isValid = aspect.check(phrase);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
