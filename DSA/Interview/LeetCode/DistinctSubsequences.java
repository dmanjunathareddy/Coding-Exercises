package com.softgroup.dsa.interview.leetcode;
public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int m = s.length();
        int n = t.length();

        // Create a DP table where dp[i][j] represents the number of distinct subsequences of t[0..j-1] in s[0..i-1]
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first column, since an empty t has exactly one subsequence in any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, we can either include it in our subsequence or exclude it
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Otherwise, we exclude the current character of s and check the remaining subsequences
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The value in dp[m][n] is the answer
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t)); // Output: 3
    }
}
