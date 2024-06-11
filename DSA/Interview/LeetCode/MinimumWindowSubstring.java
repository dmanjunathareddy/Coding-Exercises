package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int required = mapT.size(); // Number of unique characters in t that must be in the window
        int formed = 0; // Number of unique characters in the current window that match the required count

        // Frequency map for characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        int l = 0, r = 0; // Left and right pointer
        int[] ans = {-1, 0, 0}; // Length of the minimum window, left and right pointer

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if the current character added fulfills the requirement of the character in t
            if (mapT.containsKey(c) && windowCounts.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            // Contract the window until it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update the answer if this window is smaller than the previous ones
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (mapT.containsKey(c) && windowCounts.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
}
