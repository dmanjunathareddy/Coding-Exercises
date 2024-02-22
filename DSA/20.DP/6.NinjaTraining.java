package com.softgroup.dsa.dp;

public class NinjaTraining {

	public static int maxMerits(int[] merits) {
		int n = merits.length;
		int[][] dp = new int[n][3];
		for (int j = 0; j < 3; j++) {
			dp[0][j] = merits[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j != k) { // Ensure the same activity is not performed on two consecutive days
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + merits[i]);
					}
				}
			}
		}
		int maxMerits = 0;
		for (int j = 0; j < 3; j++) {
			maxMerits = Math.max(maxMerits, dp[n - 1][j]);
		}

		return maxMerits;
	}

	public static void main(String[] args) {
		int[] merits = { 3, 2, 5, 7, 3 }; // Merit points for each day
		System.out.println("Maximum merit points: " + maxMerits(merits)); // Output: 13
	}
}
