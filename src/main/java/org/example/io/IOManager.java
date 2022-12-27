package org.example.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOManager {
    private final Scanner scanner;

    private final Logger logger = LogManager.getLogger(IOManager.class);

    public IOManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getLine() {
        return scanner.nextLine();
    }

    public String readStringFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.lines().forEach(line -> stringBuilder.append(line).append(System.lineSeparator()));
            logger.info("Successfully read data from file {}", filePath);
            return stringBuilder.toString();
        } catch (IOException e) {
            logger.error("Failed to read data from file {} : {}", filePath, e.getMessage());
            logger.error("Unable to read data from file {} : Asset was replaced by an empty string", filePath);
            return "";
        }
    }

    public Set<String> readAllFileNamesFromDirectory(String directoryName) {
        try (Stream<Path> stream = Files.list(Paths.get(directoryName))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return Collections.emptySet();
    }

    public void printLine(String str) {
        System.out.println(str);
    }

    public void print(String str) {
        System.out.print(str);
    }
}
