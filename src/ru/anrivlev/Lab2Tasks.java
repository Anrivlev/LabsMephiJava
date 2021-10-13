package ru.anrivlev;
import java.util.*;

public class Lab2Tasks {
    public void task1() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry: wordsCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
    public void task2() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        Set<String> wordsCount = new TreeSet<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!wordsCount.contains(word)) {
                wordsCount.add(word);
                result.append(word);
            }
        }
        System.out.println(result);
    }
}
