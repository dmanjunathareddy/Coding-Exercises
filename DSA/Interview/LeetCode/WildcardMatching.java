package com.softgroup.dsa.interview.leetcode;
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        dp[0][0] = true; // Both strings are empty

        // Initialize dp for patterns like '*', '**', '***'
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";

        System.out.println(isMatch(s, p)); // Output: true
    }
}
