package com.softgroup.dsa.dp;

public class HouseRobber {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		if (n == 1)
			return nums[0];
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		HouseRobber robber = new HouseRobber();
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println("Maximum amount of money that can be robbed: " + robber.rob(nums)); // Output: 12
	}
}
