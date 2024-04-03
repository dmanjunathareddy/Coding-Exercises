package com.softgroup.dsa.slidingwindowtechnique;

public class MaximumSumSubarray {

	public static int maxSumSubarray(int[] nums, int k) {
		int maxSum = 0;
		int currentSum = 0;

		// Calculate sum of first k elements
		for (int i = 0; i < k; i++) {
			currentSum += nums[i];
		}
		maxSum = currentSum;

		// Slide the window to find maximum sum
		for (int i = k; i < nums.length; i++) {
			currentSum = currentSum - nums[i - k] + nums[i];
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 };
		int k = 3;
		System.out.println("Maximum sum subarray of size " + k + ": " + maxSumSubarray(nums, k));
	}
}
