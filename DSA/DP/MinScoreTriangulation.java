package com.softgroup.dsa.dp;
public class MinScoreTriangulation {
    public static int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 1, 4, 1, 5};
        System.out.println(minScoreTriangulation(A)); // Output: 13
    }
}
