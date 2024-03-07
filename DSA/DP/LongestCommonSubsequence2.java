package com.softgroup.dsa.dp;

public class LongestCommonSubsequence2 {

    public static String longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Building the LCS matrix
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // Reconstructing the LCS
        StringBuilder lcs = new StringBuilder();
        int i = text1.length(), j = text2.length();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return lcs.toString();
    }

    public static void main(String[] args) {
        String text1 = "ABCBDAB";
        String text2 = "BDCABB";

        String lcs = longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
