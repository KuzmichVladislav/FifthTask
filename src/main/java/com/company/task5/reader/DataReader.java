package com.company.task5.reader;

import com.company.task5.exception.CompositeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class DataReader {

    public String readFromFile(String filePath) throws CompositeException {
        try {
            Path path = Path.of(filePath);
            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            throw new CompositeException("Unable to open file: " + filePath, e);
        }
    }
}