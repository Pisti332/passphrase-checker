package com.codecool.passphrasechecker.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TxtFileReader implements FileReader {
    @Override
    public List<String> readByLines(String path) {
        try {
            return readFileByLines(path);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readFileByLines(String path) throws FileNotFoundException {
        List<String> linesOfTxt = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            linesOfTxt.add(currentLine);
        }
        scanner.close();
        return linesOfTxt;
    }
}
