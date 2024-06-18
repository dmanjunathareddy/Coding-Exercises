package com.softgroup.dsa.interview.leetcode;
public class MatrixChainMultiplication {

    // Method to calculate the minimum number of multiplications needed
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Since p has one more element than the number of matrices
        int[][] m = new int[n][n]; // m[i][j] will store the minimum number of multiplications needed for A[i]..A[j]

        // m[i][i] is zero since the cost of multiplying one matrix is zero
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[0][n - 1];
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4};
        System.out.println("Minimum number of multiplications is " + matrixChainOrder(p));
    }
}
