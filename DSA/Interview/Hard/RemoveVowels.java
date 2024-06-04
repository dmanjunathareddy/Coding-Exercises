package com.softgroup.dsa.interview;
import java.util.stream.Collectors;

public class RemoveVowels {
    public static void main(String[] args) {
        String text = "lorem ipsum dolor sit amet";
        String result = removeVowels(text);
        System.out.println(result);
    }

    public static String removeVowels(String input) {
        return input.chars() // Convert the String to an IntStream of characters
                     .filter(c -> "AEIOUaeiou".indexOf(c) == -1) // Filter out vowels
                     .mapToObj(c -> String.valueOf((char) c)) // Convert each int to a String
                     .collect(Collectors.joining()); // Collect to a single String
    }
}
