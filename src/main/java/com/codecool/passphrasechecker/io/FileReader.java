package com.codecool.passphrasechecker.io;

import java.util.List;

public interface FileReader {
    List<String> readByLines(String path);
}
