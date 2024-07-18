package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Create a map to store Roman numerals and their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int length = s.length();
        int result = romanMap.get(s.charAt(length - 1));

        // Loop through the string from second last character to the first
        for (int i = length - 2; i >= 0; i--) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String romanNumeral = "IV"; // Example Roman numeral
        int integer = romanToInt(romanNumeral);
        System.out.println("The integer value of " + romanNumeral + " is: " + integer);
    }
}
