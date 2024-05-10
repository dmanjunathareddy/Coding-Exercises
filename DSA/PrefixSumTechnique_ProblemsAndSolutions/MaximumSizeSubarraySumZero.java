package com.softgroup.dsa.prefixSumTechnique;

import java.util.HashMap;

public class MaximumSizeSubarraySumZero {
	public static int maxLengthSubarraySumZero(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;
		int prefixSum = 0;

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSum == 0)
				maxLength = i + 1;
			else {
				if (map.containsKey(prefixSum))
					maxLength = Math.max(maxLength, i - map.get(prefixSum));
				else
					map.put(prefixSum, i);
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, 5, -2, 3 };
		System.out.println(
				"Length of maximum size subarray with sum equal to zero is: " + maxLengthSubarraySumZero(nums));
	}
}
