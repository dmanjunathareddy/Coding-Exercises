package com.softgroup.dsa.dp;

public class LongestCommonSubsequence {

    public static int[][] lcsLength(char[] X, char[] Y) {
        int m = X.length;
        int n = Y.length;
        int[][] c = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
                }
            }
        }

        return c;
    }

    public static String printLCS(int[][] c, char[] X, char[] Y, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        } else if (X[i - 1] == Y[j - 1]) {
            return printLCS(c, X, Y, i - 1, j - 1) + X[i - 1];
        } else {
            if (c[i][j - 1] > c[i - 1][j]) {
                return printLCS(c, X, Y, i, j - 1);
            } else {
                return printLCS(c, X, Y, i - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABB";

        char[] xArray = X.toCharArray();
        char[] yArray = Y.toCharArray();

        int[][] c = lcsLength(xArray, yArray);
        String lcs = printLCS(c, xArray, yArray, xArray.length, yArray.length);
        
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
