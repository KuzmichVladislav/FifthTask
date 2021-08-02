package com.company.task5.reader;

import com.company.task5.exception.CompositeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class DataReader {

    private static final Logger logger = LogManager.getLogger();

    public String readFromFile(String filePath) throws CompositeException {
        try {
            Path path = Path.of(filePath);
            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            logger.info("Unable to open file: " + filePath);
            throw new CompositeException("Unable to open file: " + filePath, e);
        }
    }
}
