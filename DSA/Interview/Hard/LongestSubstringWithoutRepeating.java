package com.softgroup.dsa.interview;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String text = "abcabcbb";
        int result = lengthOfLongestSubstring(text);
        System.out.println(result); // Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
