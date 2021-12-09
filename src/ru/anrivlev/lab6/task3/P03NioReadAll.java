package ru.anrivlev.lab6.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {

    public static void main(String[] args) {

        List<String> fileArr;
        Path file = Paths.get("src/ru/anrivlev/lab6/task3/hamlet.txt");
        try {
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Rosencrantz ===");
            fileArr.stream().filter(line -> line.contains("Ros.")).forEach(System.out::println);


            System.out.println("\n=== Guildenstern ===");
            fileArr.stream().filter(line -> line.contains("Guil.")).forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
