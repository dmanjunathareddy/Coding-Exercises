package com.softgroup.dsa.array;
public class CountPaths {
    public static int countPaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Number of paths in a " + m + "x" + n + " matrix: " + countPaths(m, n));
    }
}
