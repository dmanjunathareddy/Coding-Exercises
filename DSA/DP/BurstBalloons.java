package com.softgroup.dsa.dp;
public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        dp[left][i - 1] + newNums[left - 1] * newNums[i] * newNums[right + 1] + dp[i + 1][right]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8}; // Example
        System.out.println("Maximum coins: " + maxCoins(nums));
    }
}


