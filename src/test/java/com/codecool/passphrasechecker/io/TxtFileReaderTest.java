package com.codecool.passphrasechecker.io;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TxtFileReaderTest {
    private static final String INPUT_FILE_PATH = "src/main/resources/input";
    private static final int INPUT_FILE_CONTENT_LENGTH = 6;
    private static FileReader fileReader;
    @BeforeEach
    void init() {
        fileReader = new TxtFileReader();
    }

    @Test
    void readByLinesDoesSizeMatchTest() {
        fileReader = new TxtFileReader();
        List<String> lines = fileReader.readByLines(INPUT_FILE_PATH);
        assertEquals(lines.size(), INPUT_FILE_CONTENT_LENGTH);

    }
    @Test
    void readByLinesInvalidInputFilePathTest() {
        fileReader = new TxtFileReader();
        String invalidInputFilePath = "src/main/resources/input1";
        assertThrows(RuntimeException.class, () -> fileReader.readByLines(invalidInputFilePath));

    }
}