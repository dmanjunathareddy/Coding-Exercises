package com.softgroup.dsa.interview.leetcode;
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = extendedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            extendedNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int length = 1; length <= n; length++) {
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][i - 1] + extendedNums[left - 1] * extendedNums[i] * extendedNums[right + 1] + dp[i + 1][right]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        BurstBalloons solution = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println("Maximum coins that can be collected: " + solution.maxCoins(nums));
    }
}
