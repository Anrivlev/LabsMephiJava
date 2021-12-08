package ru.anrivlev.lab6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("test.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
            Scanner in = new Scanner(System.in);
            String toBeFound = in.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
