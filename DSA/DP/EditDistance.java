package com.softgroup.dsa.dp;
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int r = word2.length();
        int[][] dp = new int[m + 1][r + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= r; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][r];
    }

    public static void main(String[] args) {
        String word1 = "horse"; // Example
        String word2 = "ros"; // Example
        System.out.println("Minimum edit distance between '" + word1 + "' and '" + word2 + "' is: " + minDistance(word1, word2));
    }
}


