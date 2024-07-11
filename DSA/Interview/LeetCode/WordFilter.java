package com.softgroup.dsa.interview.leetcode;
import java.util.*;

class WordFilter {
    Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int prefixLength = 1; prefixLength <= len; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= len; suffixLength++) {
                    String key = word.substring(0, prefixLength) + "#" + word.substring(len - suffixLength);
                    map.put(key, i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        return map.getOrDefault(key, -1);
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "grape"};
        WordFilter wf = new WordFilter(words);
        System.out.println(wf.f("a", "e")); // Output: 0
        System.out.println(wf.f("b", "a")); // Output: 1
        System.out.println(wf.f("g", "e")); // Output: 2
    }
}
