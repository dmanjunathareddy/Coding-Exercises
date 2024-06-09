package com.softgroup.dsa.matrix;

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        // Apply the game rules to the board using a nested loop
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

        // Update the board to the next state
        Arrays.stream(board).forEach(row -> {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == -1) {
                    row[j] = 0;
                }
                if (row[j] == 2) {
                    row[j] = 1;
                }
            }
        });
    }

    // Method to count the live neighbors of a given cell
    private static int liveNeighbors(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        return (int) Arrays.stream(new int[][]{
                {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                {i, j - 1}, {i, j + 1},
                {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1}
        }).filter(pos -> pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n)
          .filter(pos -> Math.abs(board[pos[0]][pos[1]]) == 1)
          .count();
    }

    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        gameOfLife(board);

        // Print the next state of the board
        System.out.println("Next state of the board:");
        Arrays.stream(board).map(Arrays::toString).forEach(System.out::println);
    }
}
