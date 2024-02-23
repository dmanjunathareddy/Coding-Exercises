package com.softgroup.dsa.dp;

public class MinimumCostPath {
	public static int minCostPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		// Create a dp array to store the minimum cost to reach each cell
		int[][] dp = new int[m][n];

		// Base case: initialize dp array for the first row and column
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + matrix[i][0];
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + matrix[0][j];
		}

		// Iterate through the matrix to fill in the dp array
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]); // Minimum cost to reach (i, j) equals
																				// the cost of (i, j) plus the minimum
																				// of (i-1, j) and (i, j-1)
			}
		}

		return dp[m - 1][n - 1]; // Return the minimum cost to reach the bottom-right corner
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println("Minimum cost path: " + minCostPath(matrix));
	}
}
