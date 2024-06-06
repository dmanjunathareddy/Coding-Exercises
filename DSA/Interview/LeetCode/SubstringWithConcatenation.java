package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            while (j < wordCount) {
                int wordIndex = i + j * wordLength;
                String word = s.substring(wordIndex, wordIndex + wordLength);
                if (!wordMap.containsKey(word)) {
                    break;
                }
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                if (seenWords.get(word) > wordMap.get(word)) {
                    break;
                }
                j++;
            }
            if (j == wordCount) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        List<Integer> result = findSubstring(s, words);
        System.out.println(result); // Output: [0, 9]
    }
}
