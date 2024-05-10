package com.softgroup.dsa.prefixSumTechnique;

import java.util.HashMap;

public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int prefixSum = 0;

		map.put(0, 1);

		for (int num : nums) {
			prefixSum += num;
			if (map.containsKey(prefixSum - k))
				count += map.get(prefixSum - k);
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		int k = 2;
		System.out.println("Number of subarrays with sum equal to " + k + " is: " + subarraySum(nums, k));
	}
}
