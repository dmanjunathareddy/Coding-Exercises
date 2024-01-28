package com.softgroup.dsa.matrix;

public class PrintMatrixDiagonals {

    public static void printDiagonals(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Print the primary diagonal
        System.out.print("Primary Diagonal: ");
        for (int i = 0; i < rows && i < cols; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        // Print the secondary diagonal
        System.out.print("Secondary Diagonal: ");
        for (int i = 0; i < rows && i < cols; i++) {
            System.out.print(matrix[i][cols - 1 - i] + " ");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        printDiagonals(matrix);
    }
}

