package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                char[] currentCharArray = currentWord.toCharArray();

                for (int j = 0; j < currentCharArray.length; j++) {
                    char originalChar = currentCharArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }

                        currentCharArray[j] = c;
                        String newWord = new String(currentCharArray);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    currentCharArray[j] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result); // Output: 5
    }
}
