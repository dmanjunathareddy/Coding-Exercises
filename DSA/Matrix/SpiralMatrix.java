package com.softgroup.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // Method to return elements of the matrix in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Handle edge case where matrix is empty
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left if there are still rows remaining
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top if there are still columns remaining
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    // Main method to test the spiralOrder function
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print the result in spiral order
        System.out.println("Spiral order: " + spiralOrder(matrix));
        // Expected Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
