package ru.anrivlev.lab6.task1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static void main(String[] args) {
        try {
            // command:
            // java src/ru/anrivlev/lab6/task1/Main.java src/ru/anrivlev/lab6/task1/text.txt
            // "src/ru/anrivlev/lab6/task1/text.txt" is a file to use
            FileInputStream file = new FileInputStream(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            Scanner in = new Scanner(System.in);
            String toBeFound = in.nextLine();
            int counter = 0;
            while (reader.ready()) {
                String currentLine = reader.readLine();
                if (currentLine.contains(toBeFound)) {
                    counter = counter + count(currentLine, toBeFound);
                }
            }
            System.out.println("Number of occurrences of the string: " + counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
