package com.softgroup.dsa.interview.leetcode;
public class RegexMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] means whether s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Deals with patterns like a*, a*b*, a*b*c*
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // Current characters match or pattern has '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // '*' matches zero of the preceding element
                    dp[i][j] = dp[i][j - 2];
                    // '*' matches one or more of the preceding element
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        System.out.println("Does the string match the pattern? " + isMatch(s, p)); // Output: true

        String s2 = "mississippi";
        String p2 = "mis*is*p*.";

        System.out.println("Does the string match the pattern? " + isMatch(s2, p2)); // Output: false
    }
}
