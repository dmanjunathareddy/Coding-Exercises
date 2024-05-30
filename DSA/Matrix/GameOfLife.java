package com.softgroup.dsa.matrix;

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, i, j);

                if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j] = -1; // -1 means it was live but now dead
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;  // 2 means it was dead but now live
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static int liveNeighbors(int[][] board, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[0].length - 1); y++) {
                if (x != i || y != j) {
                    if (Math.abs(board[x][y]) == 1) {
                        lives++;
                    }
                }
            }
        }
        return lives;
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        gameOfLife(board);
        System.out.println("Next state of the board:");
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        // Output:
        // [0, 0, 0]
        // [1, 0, 1]
        // [0, 1, 1]
        // [0, 1, 0]
    }
}
