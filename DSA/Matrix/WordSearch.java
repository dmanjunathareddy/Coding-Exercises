package com.softgroup.dsa.matrix;
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        
        char temp = board[i][j];
        board[i][j] = '#'; // Mark the cell as visited
        
        boolean found = dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1);
        
        board[i][j] = temp; // Unmark the cell
        
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println("Word exists: " + exist(board, word)); // Output: true
    }
}
