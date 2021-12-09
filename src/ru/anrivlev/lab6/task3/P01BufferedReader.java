package ru.anrivlev.lab6.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01BufferedReader {

    public static void main(String[] args) {

        try {
            BufferedReader bReader =
                    new BufferedReader(new FileReader("src/ru/anrivlev/lab6/task3/hamlet.txt"));
            System.out.println("=== Entire File ===");
            while (bReader.ready()) {
                System.out.println(bReader.readLine());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
