package com.softgroup.dsa.dp;

public class LongestPalindromicSubsequence {

	public static int longestPalindromicSubsequenceLength(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && len == 2) {
					dp[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String s = "Nitin";
		int length = longestPalindromicSubsequenceLength(s);
		System.out.println("Length of Longest Palindromic Subsequence: " + length);
	}
}
