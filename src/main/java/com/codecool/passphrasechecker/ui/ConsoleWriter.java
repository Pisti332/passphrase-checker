package com.codecool.passphrasechecker.ui;

public class ConsoleWriter implements ValueDisplay {
    @Override
    public void showNumber(short number) {
        System.out.println(number);
    }

    @Override
    public void showNumber(int number) {
        System.out.println(number);
    }

    @Override
    public void showNumber(long number) {
        System.out.println(number);
    }
}
