package com.softgroup.dsa.dp;

public class CountPartitionsWithGivenDifference {

    public static int countPartitions(int[] nums, int difference) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum and the given difference are odd, it's not possible to partition
        if ((totalSum + difference) % 2 != 0) {
            return 0;
        }

        int targetSum = (totalSum + difference) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][targetSum + 1];
        
        // Base case initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Dynamic programming approach
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int difference = 1;
        int count = countPartitions(nums, difference);
        System.out.println("Number of partitions with the given difference: " + count);
    }
}
