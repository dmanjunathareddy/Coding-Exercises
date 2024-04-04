package com.softgroup.dsa.prefixSumTechnique;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

	public static int numSubarraysWithSum(int[] nums, int goal) {
		Map<Integer, Integer> prefixSumCount = new HashMap<>();
		prefixSumCount.put(0, 1); // Initialize with prefix sum 0

		int prefixSum = 0;
		int count = 0;

		for (int num : nums) {
			prefixSum += num;
			count += prefixSumCount.getOrDefault(prefixSum - goal, 0);
			prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, 1, 0, 1 };
		int goal = 2;
		System.out.println("Number of non-empty subarrays with sum " + goal + ": " + numSubarraysWithSum(nums, goal));
	}
}
