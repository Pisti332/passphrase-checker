package com.codecool.passphrasechecker.ui;

public class ConsoleWriter implements ValueDisplay {
    @Override
    public void showNumberOfValidPhrases(int number) {
        String outputPhrase = "Helyes jelmondatok szama: ";
        System.out.println(outputPhrase + number);
    }
}
