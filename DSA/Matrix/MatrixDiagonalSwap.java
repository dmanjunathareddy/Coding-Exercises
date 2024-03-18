package com.softgroup.dsa.matrix;

public class MatrixDiagonalSwap {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Display original matrix
        System.out.println("Original Matrix:");
        displayMatrix(matrix);

        // Swap diagonals
        swapDiagonals(matrix);

        // Display matrix after swapping diagonals
        System.out.println("\nMatrix after swapping diagonals:");
        displayMatrix(matrix);
    }

    // Method to swap major and minor diagonals
    public static void swapDiagonals(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            int temp = matrix[i][i]; // Store the element of major diagonal
            matrix[i][i] = matrix[i][size - 1 - i]; // Swap major diagonal with minor diagonal
            matrix[i][size - 1 - i] = temp; // Restore stored element to minor diagonal
        }
    }

    // Method to display the matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
