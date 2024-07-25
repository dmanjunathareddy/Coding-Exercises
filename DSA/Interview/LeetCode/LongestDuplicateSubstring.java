package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class LongestDuplicateSubstring {

    public String longestDupSubstring(String s) {
        int left = 1;
        int right = s.length();
        String result = "";

        while (left < right) {
            int mid = left + (right - left) / 2;
            String dup = findDuplicateSubstring(s, mid);
            if (dup != null) {
                if (dup.length() > result.length()) {
                    result = dup;
                }
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return result;
    }

    private String findDuplicateSubstring(String s, int len) {
        if (len == 0) return null;

        long mod = (long)1e9 + 7;
        long base = 31;

        long hash = 0;
        long baseL = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i)) % mod;
            baseL = (baseL * base) % mod;
        }

        Set<Long> seen = new HashSet<>();
        seen.add(hash);

        for (int i = len; i < s.length(); i++) {
            hash = (hash * base - s.charAt(i - len) * baseL % mod + mod) % mod;
            hash = (hash + s.charAt(i)) % mod;
            if (!seen.add(hash)) {
                return s.substring(i - len + 1, i + 1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LongestDuplicateSubstring solver = new LongestDuplicateSubstring();
        String s = "banana";
        System.out.println(solver.longestDupSubstring(s)); // Output: "ana"
    }
}
