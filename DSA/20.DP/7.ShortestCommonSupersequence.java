package com.softgroup.dsa.dp;

public class ShortestCommonSupersequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Initialize a 2D array to store the length of the shortest common supersequence
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up dynamic programming approach
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // If one of the strings is empty, supersequence length = length of other string
                    dp[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, include only once in supersequence
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If characters don't match, choose the minimum of including either one of them
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Construct the shortest common supersequence from dp array
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // If characters match, include only once in supersequence
                sb.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                // If character from str1 is included in supersequence
                sb.insert(0, str1.charAt(i - 1));
                i--;
            } else {
                // If character from str2 is included in supersequence
                sb.insert(0, str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters from str1, if any
        while (i > 0) {
            sb.insert(0, str1.charAt(i - 1));
            i--;
        }

        // Append remaining characters from str2, if any
        while (j > 0) {
            sb.insert(0, str2.charAt(j - 1));
            j--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "ABC";
        String str2 = "ACBC";

        String shortestCommonSupersequence = shortestCommonSupersequence(str1, str2);
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence);
    }
}

