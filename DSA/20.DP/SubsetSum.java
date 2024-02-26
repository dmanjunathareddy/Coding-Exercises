package com.softgroup.dsa.dp;

public class SubsetSum {

	public static boolean isSubsetSum(int[] nums, int target) {
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][target + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;
		for (int i = 1; i <= target; i++)
			dp[0][i] = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (j < nums[i - 1])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
			}
		}
		return dp[n][target];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1 };
		int target = 5;
		if (isSubsetSum(nums, target))
			System.out.println("There exists a subset with sum equal to " + target);
		else
			System.out.println("No subset with sum equal to " + target + " exists.");
	}
}
