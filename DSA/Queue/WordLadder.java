package com.softgroup.dsa.queue;

import java.util.*;

public class WordLadder {

    // Function to find the shortest transformation sequence length
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a set from the word list for faster lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If the end word is not in the word list, no transformation is possible
        }

        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        // Enqueue the begin word with an initial length of 1
        queue.offer(beginWord);
        int length = 1;

        // Perform BFS
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            // Process each word at the current level
            for (int i = 0; i < queueSize; i++) {
                // Get the current word from the queue
                String currentWord = queue.poll();

                // Iterate through each character in the word
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    // Try changing each character from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        // Skip if the character is the same as the current character
                        if (wordArray[j] == c) {
                            continue;
                        }

                        // Change the character and form a new word
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        // Check if the new word is the end word
                        if (newWord.equals(endWord)) {
                            return length + 1; // Return the length including the current level
                        }

                        // If the new word is in the word set, enqueue it and remove it from the set
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            length++; // Increment the length after processing the current level
        }

        return 0; // Return 0 if no transformation sequence is found
    }

    // Example usage
    public static void main(String[] args) {
        // Sample word list (dictionary)
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        // Start and end words
        String beginWord = "hit";
        String endWord = "cog";

        // Find the shortest transformation sequence length
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Ladder Length: " + result);
    }
}
