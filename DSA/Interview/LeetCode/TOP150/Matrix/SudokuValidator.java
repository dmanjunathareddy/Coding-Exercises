package com.softgroup.dsa.interview.leetcode.top150;
public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {
        // Check each row, column, and 3x3 sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Convert character to index (0-8)
                    int boxIndex = (i / 3) * 3 + j / 3; // Determine 3x3 sub-box index

                    // Check if the number has already been seen in the current row, column, or 3x3 sub-box
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    // Mark the number as seen in the current row, column, and 3x3 sub-box
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuValidator validator = new SudokuValidator();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValid = validator.isValidSudoku(board);
        System.out.println("The Sudoku board is valid: " + isValid);
    }
}
