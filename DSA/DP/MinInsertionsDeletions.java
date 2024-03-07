package com.softgroup.dsa.dp;

public class MinInsertionsDeletions {

    public static int minOperations(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Initialize a 2D array to store the minimum operations required
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using bottom-up dynamic programming approach
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // If one of the strings is empty, minimum operations = length of other string
                    dp[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, no additional operations required
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If characters don't match, choose minimum of deletion or insertion
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the minimum number of operations required to convert str1 to str2
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        int minOperationsRequired = minOperations(str1, str2);
        System.out.println("Minimum operations required: " + minOperationsRequired);
    }
}
