package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

    public String makeLargestSpecial(String S) {
        // List to hold the special substrings
        List<String> specialStrings = new ArrayList<>();
        int count = 0, start = 0;
        
        for (int i = 0; i < S.length(); i++) {
            // Count the number of 1s and 0s
            if (S.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            
            // When count is zero, we have a valid special substring
            if (count == 0) {
                // Recursively solve the inner substring and add "1" and "0" at the ends
                String inner = S.substring(start + 1, i);
                String special = "1" + makeLargestSpecial(inner) + "0";
                specialStrings.add(special);
                start = i + 1;
            }
        }
        
        // Sort the special substrings in descending order
        Collections.sort(specialStrings, Collections.reverseOrder());
        
        // Concatenate the sorted special substrings
        StringBuilder result = new StringBuilder();
        for (String str : specialStrings) {
            result.append(str);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        SpecialBinaryString solver = new SpecialBinaryString();
        
        // Example usage
        String input = "11011000";
        String result = solver.makeLargestSpecial(input);
        
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
