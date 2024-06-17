package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        
        node = node.children[c - 'a'];
        if (node.word != null) {   // found one
            result.add(node.word);
            node.word = null;     // de-duplicate
        }
        
        board[i][j] = '#';  // mark as visited
        
        if (i > 0) dfs(board, i - 1, j, node, result); 
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result); 
        
        board[i][j] = c;  // restore the original character
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.word = word;
        }
        return root;
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(ws.findWords(board, words)); // Output: [oath, eat]
    }
}
