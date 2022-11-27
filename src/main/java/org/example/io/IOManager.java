package org.example.io;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class IOManager {
    private final Scanner scanner;

    public IOManager() {
        scanner = new Scanner(System.in);
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void printLine(String str) {
        System.out.println(str);
    }

    public Optional<String> tryReadFile(String filePath) {
        try {
            return Optional.of(readStringFromFile(filePath));
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        return Optional.empty();
    }

    private String readStringFromFile(String filePath) throws FileNotFoundException{
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.lines().forEach(line -> stringBuilder.append(line).append("\n"));
        return stringBuilder.toString();
    }

    public void close() {
        scanner.close();
    }
}
