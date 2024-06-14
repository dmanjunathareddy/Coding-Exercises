package com.softgroup.dsa.interview.leetcode;
public class PalindromePartitioningII {

    public int minCut(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // dp[i] will be the minimum cut for substring s(0, i)
        int[] dp = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int minCuts = i; // Maximum cuts would be (i) cuts for a string of length (i + 1)
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    // If the whole substring s(0, j) is a palindrome, no cut is needed
                    // Otherwise, add 1 cut to the minimum cuts needed for the previous substrings
                    minCuts = j == 0 ? 0 : Math.min(minCuts, dp[j - 1] + 1);
                }
            }
            dp[i] = minCuts;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningII solution = new PalindromePartitioningII();
        String s = "aab";
        System.out.println(solution.minCut(s)); // Output: 1
    }
}
