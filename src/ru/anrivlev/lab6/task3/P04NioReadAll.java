package ru.anrivlev.lab6.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P04NioReadAll {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static void main(String[] args) {

        Path file = Paths.get("src/ru/anrivlev/lab6/task3/hamlet.txt");
        List<String> fileArr;

        try {
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Lord Count ===");
            long wordCount =
                    fileArr.stream()
                            .map(String::toLowerCase)
                            .filter(line -> line.contains("lord"))
                            .mapToInt(line -> count(line, "lord"))
                            .sum();

            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount =
                    fileArr.stream()
                            .map(String::toLowerCase)
                            .filter(line -> line.contains("prison"))
                            .mapToInt(line -> count(line, "prison"))
                            .sum();

            System.out.println("Word count: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
