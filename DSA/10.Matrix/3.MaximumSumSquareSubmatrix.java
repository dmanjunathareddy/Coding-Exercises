package com.softgroup.dsa.matrix;

public class MaximumSumSquareSubmatrix {

	public static int findMaxSumSubmatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0; // Return 0 if the matrix is empty or invalid
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows + 1][cols + 1];

		// Initialize the dp array with cumulative sums
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}

		int maxSum = Integer.MIN_VALUE;

		// Iterate through all possible square submatrices
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				for (int size = 1; size <= Math.min(rows - i + 1, cols - j + 1); size++) {
					int sum = dp[i + size - 1][j + size - 1] - dp[i - 1][j + size - 1] - dp[i + size - 1][j - 1]
							+ dp[i - 1][j - 1];

					maxSum = Math.max(maxSum, sum);
				}
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

		int maxSum = findMaxSumSubmatrix(matrix);
		System.out.println("Maximum Sum Square Submatrix: " + maxSum);
	}
}
