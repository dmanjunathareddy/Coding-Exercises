package com.softgroup.dsa.interview.leetcode;
public class StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        StrangePrinter printer = new StrangePrinter();
        System.out.println(printer.strangePrinter("aaabbb")); // Example test case
        System.out.println(printer.strangePrinter("aba"));
    }
}
