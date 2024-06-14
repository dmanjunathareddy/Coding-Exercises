package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Use a HashSet for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        // Create a memoization map to store already computed results
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        // Check if the result for the current substring is already computed
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> results = new ArrayList<>();

        // If the whole string is a word, add it to the results
        if (wordSet.contains(s)) {
            results.add(s);
        }

        // Try every possible break point
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixBreaks = wordBreakHelper(suffix, wordSet, memo);
                for (String suffixBreak : suffixBreaks) {
                    results.add(prefix + " " + suffixBreak);
                }
            }
        }

        // Store the result in the memo map
        memo.put(s, results);
        return results;
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> result = solution.wordBreak(s, wordDict);
        for (String sentence : result) {
            System.out.println(sentence);
        }
        // Output:
        // cats and dog
        // cat sand dog
    }
}
