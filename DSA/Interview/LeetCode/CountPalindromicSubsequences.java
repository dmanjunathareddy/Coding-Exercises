package com.softgroup.dsa.interview.leetcode;
public class CountPalindromicSubsequences {
    private static final int MOD = 1000000007;

    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = 1;
                } else if (len == 2) {
                    dp[i][j] = S.charAt(i) == S.charAt(j) ? 2 : 2;
                } else {
                    if (S.charAt(i) == S.charAt(j)) {
                        int low = i + 1, high = j - 1;
                        while (low <= high && S.charAt(low) != S.charAt(i)) low++;
                        while (low <= high && S.charAt(high) != S.charAt(j)) high--;

                        if (low > high) {
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                        } else if (low == high) {
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                        }
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + MOD : dp[i][j] % MOD;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        CountPalindromicSubsequences solver = new CountPalindromicSubsequences();
        System.out.println(solver.countPalindromicSubsequences("bccb")); // 6
        System.out.println(solver.countPalindromicSubsequences("aaa")); // 3
    }
}
