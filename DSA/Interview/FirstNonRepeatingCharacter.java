package com.softgroup.dsa.interview;
import java.util.*;

public class FirstNonRepeatingCharacter {
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (countMap.get(c) == 1) {
                return c;
            }
        }
        return '_'; // If no non-repeating character exists
    }

    public static void main(String[] args) {
        String s = "swiss";
        System.out.println("First non-repeating character: " + firstNonRepeatingChar(s)); // Output: w
    }
}
