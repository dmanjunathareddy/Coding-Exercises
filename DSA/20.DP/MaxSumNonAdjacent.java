package com.softgroup.dsa.dp;

public class MaxSumNonAdjacent {
    
    public static int maxSumNonAdjacent(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n]; // dp[i] will store the maximum sum of non-adjacent elements ending at index i
        
        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            // At each step, we have two options:
            // 1. Include the current element and the maximum sum of non-adjacent elements
            // ending at i-2.
            // 2. Exclude the current element and keep the maximum sum of non-adjacent
            // elements ending at i-1.
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 2, 5}; // Example array
        System.out.println("Maximum sum of non-adjacent elements: " + maxSumNonAdjacent(nums));
    }
}
