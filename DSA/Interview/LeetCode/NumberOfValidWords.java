package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class NumberOfValidWords {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCountMap = new HashMap<>();
        
        // Count frequency of each word's bitmask
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            wordCountMap.put(mask, wordCountMap.getOrDefault(mask, 0) + 1);
        }
        
        List<Integer> results = new ArrayList<>();
        for (String puzzle : puzzles) {
            int firstCharMask = 1 << (puzzle.charAt(0) - 'a');
            int puzzleMask = 0;
            
            // Calculate puzzle's bitmask
            for (char c : puzzle.toCharArray()) {
                puzzleMask |= 1 << (c - 'a');
            }
            
            // Iterate through all submasks of the puzzle mask
            int count = 0;
            int submask = puzzleMask;
            while (submask > 0) {
                // Ensure the first letter is included in the submask
                if ((submask & firstCharMask) == firstCharMask) {
                    count += wordCountMap.getOrDefault(submask, 0);
                }
                submask = (submask - 1) & puzzleMask;
            }
            
            // Check the empty submask (only the first character is considered)
            if (wordCountMap.containsKey(firstCharMask)) {
                count += wordCountMap.get(firstCharMask);
            }
            
            results.add(count);
        }
        
        return results;
    }

    public static void main(String[] args) {
        NumberOfValidWords solver = new NumberOfValidWords();
        String[] words = {"apple", "pleas", "please"};
        String[] puzzles = {"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"};
        List<Integer> result = solver.findNumOfValidWords(words, puzzles);
        for (int count : result) {
            System.out.println(count);  // Outputs the number of valid words for each puzzle
        }
    }
}
