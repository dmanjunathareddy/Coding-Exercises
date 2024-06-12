package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base cases
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check if the result is already cached
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Check if s1 and s2 have the same characters (anagram check)
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int count : letters) {
            if (count != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Check if swapping or not swapping results in a scramble
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                 isScramble(s1.substring(i), s2.substring(i))) ||
                (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                 isScramble(s1.substring(i), s2.substring(0, n - i)))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(scrambleString.isScramble(s1, s2)); // Output: true
    }
}
