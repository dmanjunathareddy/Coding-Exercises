package com.softgroup.dsa.dp;

public class DistinctSubsequences {

    public static int distinctSubsequencesCount(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] stores the number of distinct subsequences of s2[0...j-1] in s1[0...i-1]
        int[][] dp = new int[m + 1][n + 1];

        // Empty string is a subsequence of any string, so there is one occurrence
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array using bottom-up dynamic programming approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we have two options:
                    // 1. Include the current character in both strings and count subsequences without them (dp[i-1][j-1])
                    // 2. Exclude the current character in s1 and count subsequences (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If the characters don't match, exclude the current character in s1 and count subsequences
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The last cell of dp array stores the number of distinct subsequences
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";

        int count = distinctSubsequencesCount(s1, s2);
        System.out.println("Number of distinct subsequences of '" + s2 + "' in '" + s1 + "': " + count);
    }
}
