package com.softgroup.dsa.interview.leetcode;
import java.util.HashSet;
import java.util.Set;

class StreamChecker {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;
    private StringBuilder stream;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        // Build the trie in reverse order
        for (String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean query(char letter) {
        stream.append(letter);
        TrieNode node = root;
        // Check from the last inserted character towards the start
        for (int i = stream.length() - 1; i >= 0; i--) {
            int index = stream.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
            if (node.isEndOfWord) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker streamChecker = new StreamChecker(words);

        System.out.println(streamChecker.query('a')); // false
        System.out.println(streamChecker.query('b')); // false
        System.out.println(streamChecker.query('c')); // false
        System.out.println(streamChecker.query('d')); // true, because 'cd' is in the words list
        System.out.println(streamChecker.query('e')); // false
        System.out.println(streamChecker.query('f')); // true, because 'f' is in the words list

        System.out.println(streamChecker.query('i')); // false
        System.out.println(streamChecker.query('j')); // false
        System.out.println(streamChecker.query('k')); // false
        System.out.println(streamChecker.query('l')); // true, because 'kl' is in the words list
    }
}
