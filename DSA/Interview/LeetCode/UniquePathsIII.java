package com.softgroup.dsa.interview.leetcode;
class UniquePathsIII {
    private int rows, cols;
    private int emptyCount = 1; // To count the starting point as empty
    private int startRow, startCol, endRow, endCol;
    private int[][] grid;
    private final int[] rowOffsets = {0, 0, 1, -1};
    private final int[] colOffsets = {1, -1, 0, 0};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    emptyCount++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 2) {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        return backtrack(startRow, startCol, 0);
    }

    private int backtrack(int row, int col, int count) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == -1) {
            return 0;
        }

        if (row == endRow && col == endCol) {
            return count == emptyCount ? 1 : 0;
        }

        grid[row][col] = -1;
        int paths = 0;

        for (int i = 0; i < 4; i++) {
            paths += backtrack(row + rowOffsets[i], col + colOffsets[i], count + 1);
        }

        grid[row][col] = 0;
        return paths;
    }
}
