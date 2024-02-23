package com.softgroup.dsa.dp;

public class MinimumPathSumInTriangularMatrix {
    public static int minPathSum(int[][] triangle) {
        int n = triangle.length;

        // Create a dp array to store the minimum path sum to reach each cell
        int[][] dp = new int[n][n];

        // Initialize the dp array with the values of the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        // Iterate through the triangle from bottom to top to fill in the dp array
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]); // Minimum path sum to reach (i, j) equals the value of (i, j) plus the minimum of (i+1, j) and (i+1, j+1)
            }
        }

        return dp[0][0]; // Return the minimum path sum to reach the first row
    }

    public static void main(String[] args) {
        int[][] triangle = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
        };
        System.out.println("Minimum path sum: " + minPathSum(triangle));
    }
}
