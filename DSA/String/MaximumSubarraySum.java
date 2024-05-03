package com.softgroup.dsa.string;

public class MaximumSubarraySum {
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSubarraySum maxSubarraySum = new MaximumSubarraySum();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = maxSubarraySum.maxSubArray(nums);
		System.out.println("Maximum Subarray Sum: " + maxSum);
	}
}
