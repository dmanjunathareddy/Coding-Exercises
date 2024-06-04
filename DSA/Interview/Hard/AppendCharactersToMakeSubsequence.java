package com.softgroup.dsa.interview;
public class AppendCharactersToMakeSubsequence {

    public static int minCharactersToAppend(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Step 1: Compute the Longest Common Subsequence (LCS) length
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];

        // Step 2: Calculate the minimum characters to append
        return n - lcsLength;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aebdc";

        int result = minCharactersToAppend(s1, s2);
        System.out.println("Minimum characters to append: " + result); // Output: 2
    }
}
