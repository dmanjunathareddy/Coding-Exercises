package com.softgroup.dsa.leetcode75;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("maxSubArray>>>" + maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int maxEndhere = nums[0];
		int maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndhere = Math.max(nums[i], nums[i] + maxEndhere);
			maxSoFar = Math.max(maxSoFar, maxEndhere);
		}
		return maxSoFar;
	}
}
