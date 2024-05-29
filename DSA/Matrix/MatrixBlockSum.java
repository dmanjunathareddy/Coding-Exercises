package com.softgroup.dsa.matrix;

import java.util.Arrays;

public class MatrixBlockSum {
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);
                int r2 = Math.min(m - 1, i + K);
                int c2 = Math.min(n - 1, j + K);

                answer[i][j] = dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int K = 1;
        int[][] result = matrixBlockSum(mat, K);

        System.out.println("Matrix block sum:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        // Output:
        // [12, 21, 16]
        // [27, 45, 33]
        // [24, 39, 28]
    }
}
