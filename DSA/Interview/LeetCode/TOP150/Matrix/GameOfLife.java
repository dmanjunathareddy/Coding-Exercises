package com.softgroup.dsa.interview.leetcode.top150;
public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // Directions array to traverse the 8 neighbors of a cell
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
        
        // Create a copy of the original board to avoid modifying the input while calculating
        int[][] copyBoard = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                // Check all 8 neighbors
                for (int[] direction : directions) {
                    int row = i + direction[0];
                    int col = j + direction[1];
                    
                    // Check the validity of the neighboring cell and if it was originally a live cell
                    if (row >= 0 && row < m && col >= 0 && col < n && copyBoard[row][col] == 1) {
                        liveNeighbors++;
                    }
                }
                
                // Rule 1 or Rule 3
                if (copyBoard[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }
                
                // Rule 4
                if (copyBoard[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        
        System.out.println("Initial Board:");
        printBoard(board);
        
        gameOfLife(board);
        
        System.out.println("Board after applying the Game of Life rules:");
        printBoard(board);
    }
}
