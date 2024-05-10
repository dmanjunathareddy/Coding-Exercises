package com.softgroup.dsa.prefixSumTechnique;

public class SubarraysWithSumLessThanK {
	public static int subarraysWithSumLessThanK(int[] nums, int k) {
		int count = 0;
		int prefixSum = 0;
		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			prefixSum += nums[right];
			while (prefixSum >= k) {
				prefixSum -= nums[left];
				left++;
			}
			count += right - left + 1;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int k = 4;
		System.out.println("Number of subarrays with sum less than or equal to " + k + " is: "
				+ subarraysWithSumLessThanK(nums, k));
	}
}
