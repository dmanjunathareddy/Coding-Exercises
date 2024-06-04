package com.softgroup.dsa.interview;
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can the array be partitioned: " + canPartition(nums)); // Output: true
    }
}
