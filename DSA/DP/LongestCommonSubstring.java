package com.softgroup.dsa.dp;

public class LongestCommonSubstring {

	public static String longestCommonSubstring(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m + 1][n + 1];
		int maxLength = 0;
		int endIndex = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLength) {
						maxLength = dp[i][j];
						endIndex = i;
					}
				}
			}
		}

		return text1.substring(endIndex - maxLength, endIndex);
	}

	public static void main(String[] args) {
		String text1 = "ABCBDAB";
		String text2 = "BDCABB";

		String longestCommonSubstring = longestCommonSubstring(text1, text2);
		System.out.println("Longest Common Substring: " + longestCommonSubstring);
	}
}
