package com.softgroup.dsa.interview;
public class PalindromePartitioning {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int minCuts = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    minCuts = j == 0 ? 0 : Math.min(minCuts, dp[j - 1] + 1);
                }
            }
            dp[i] = minCuts;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts needed for a palindrome partitioning: " + minCut(s)); // Output: 1
    }
}
