package com.softgroup.dsa.interview;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String text = "swiss";
        Character result = findFirstNonRepeatedCharacter(text);
        System.out.println(result); // Output: w
    }

    public static Character findFirstNonRepeatedCharacter(String input) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Count the occurrences of each character
        input.chars()
             .mapToObj(c -> (char) c)
             .forEach(c -> charCount.put(c, charCount.getOrDefault(c, 0) + 1));

        // Find the first non-repeated character
        return charCount.entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(null);
    }
}
