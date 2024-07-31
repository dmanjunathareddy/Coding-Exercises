package com.softgroup.dsa.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlidingWindowProblem4 {
    public static List<Integer> findAnagramIndices(String s, String pattern) {
        List<Integer> indices = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int matched = 0;
        int left = 0;

        for (char ch : pattern.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0)
                    matched++;
            }

            if (matched == map.size())
                indices.add(left);

            if (right - left + 1 >= pattern.length()) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String pattern = "abc";
        System.out.println("Starting indices of anagrams of pattern in the string are: " + findAnagramIndices(s, pattern));
    }
}
