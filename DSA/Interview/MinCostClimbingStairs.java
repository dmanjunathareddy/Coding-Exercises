package com.softgroup.dsa.interview;
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Minimum cost to climb stairs: " + minCostClimbingStairs(cost)); // Output: 15
    }
}
