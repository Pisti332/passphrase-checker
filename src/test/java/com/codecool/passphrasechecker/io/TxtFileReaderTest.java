package com.codecool.passphrasechecker.io;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TxtFileReaderTest {
    private static final String INPUT_FILE_PATH = "src/main/resources/input";
    private static final int INPUT_FILE_CONTENT_LENGTH = 6;

    @Test
    void readByLinesDoesSizeMatchTest() {
        FileReader fileReader = new TxtFileReader();
        List<String> lines = fileReader.readByLines(INPUT_FILE_PATH);
        assertEquals(lines.size(), INPUT_FILE_CONTENT_LENGTH);

    }
}