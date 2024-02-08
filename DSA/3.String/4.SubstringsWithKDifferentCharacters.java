package com.softgroup.dsa.string;

import java.util.*;

public class SubstringsWithKDifferentCharacters {

    public static int countSubstringsWithKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        int n = s.length();
        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < n) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            right++;

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            count += right - left; // Substrings ending at 'right' contribute to the count
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int k = 2;
        System.out.println("Number of substrings with exactly " + k + " different characters: " + countSubstringsWithKDistinct(s, k));
    }
}
