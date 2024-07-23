package com.softgroup.dsa.interview.leetcode;
class MinimumCostToMergeStones {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        int[][] dp = new int[n][n];
        for (int len = K; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumCostToMergeStones solution = new MinimumCostToMergeStones();
        int[] stones1 = {3, 2, 4, 1};
        int K1 = 2;
        System.out.println(solution.mergeStones(stones1, K1)); // Output: 20

        int[] stones2 = {3, 2, 4, 1};
        int K2 = 3;
        System.out.println(solution.mergeStones(stones2, K2)); // Output: -1

        int[] stones3 = {3, 5, 1, 2, 6};
        int K3 = 3;
        System.out.println(solution.mergeStones(stones3, K3)); // Output: 25
    }
}
