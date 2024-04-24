package com.softgroup.dsa.matrix;

public class FloodFill {

    // Function to perform flood fill
    public static void floodFill(int[][] matrix, int row, int col, int targetColor, int newColor) {
        // Base cases
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }
        if (matrix[row][col] != targetColor) {
            return;
        }

        // Fill current cell with new color
        matrix[row][col] = newColor;

        // Recursively fill adjacent cells
        floodFill(matrix, row + 1, col, targetColor, newColor); // Down
        floodFill(matrix, row - 1, col, targetColor, newColor); // Up
        floodFill(matrix, row, col + 1, targetColor, newColor); // Right
        floodFill(matrix, row, col - 1, targetColor, newColor); // Left
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 1, 1}
        };

        int row = 2;
        int col = 2;
        int targetColor = matrix[row][col];
        int newColor = 2;

        floodFill(matrix, row, col, targetColor, newColor);

        // Print the updated matrix
        for (int[] rowArr : matrix) {
            for (int cell : rowArr) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
