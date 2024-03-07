package com.softgroup.dsa.dp;

public class MaxChocolates {

	public static int maxChocolates(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		int[][] dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = mat[i][j];
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				int maxChocolates = dp[i + 1][j];
				if (j > 0) {
					maxChocolates = Math.max(maxChocolates, dp[i + 1][j - 1]);
				}
				if (j < m - 1) {
					maxChocolates = Math.max(maxChocolates, dp[i + 1][j + 1]);
				}
				dp[i][j] += maxChocolates;
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		System.out.println("Maximum number of chocolates: " + maxChocolates(mat));
	}
}
