package ru.anrivlev.lab6.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
  public static void main(String[] args) {

    try (Stream<Path> files = Files.list(Paths.get(args[0]))) {

        System.out.println("\n=== Dir list ===");
        files.forEach(System.out::println);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  } 
}
