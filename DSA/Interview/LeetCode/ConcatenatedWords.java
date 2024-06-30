package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat");
        List<String> result = findAllConcatenatedWordsInADict(words);
        System.out.println("Concatenated Words: " + result);
    }

    public static List<String> findAllConcatenatedWordsInADict(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        List<String> concatenatedWords = new ArrayList<>();

        for (String word : words) {
            if (canForm(word, wordSet)) {
                concatenatedWords.add(word);
            }
        }

        return concatenatedWords;
    }

    private static boolean canForm(String word, Set<String> wordSet) {
        if (word.isEmpty()) {
            return false;
        }

        int length = word.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int j = (i == length ? 1 : 0); j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[length];
    }
}
