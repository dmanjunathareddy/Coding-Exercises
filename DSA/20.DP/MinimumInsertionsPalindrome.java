package com.softgroup.dsa.dp;

public class MinimumInsertionsPalindrome {

    public static int minInsertions(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Find the length of Longest Common Subsequence (LCS) between str and its reverse
        int lcsLength = lcsLength(str, new StringBuilder(str).reverse().toString(), n, n, dp);

        // Minimum insertions = Length of string - Length of LCS
        return n - lcsLength;
    }

    // Function to find the length of Longest Common Subsequence (LCS)
    public static int lcsLength(String X, String Y, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n]; // Corrected indexing here
    }

    public static void main(String[] args) {
        String str = "nitin";
        int minInsertionsRequired = minInsertions(str);
        System.out.println("Minimum insertions required to make the string palindrome: " + minInsertionsRequired);
    }
}

