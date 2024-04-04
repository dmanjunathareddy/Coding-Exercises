package com.softgroup.dsa.prefixSumTechnique;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

	public static int countNiceSubarrays(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		int count = 0;
		int oddCount = 0;

		countMap.put(0, 1);

		for (int num : nums) {
			if (num % 2 == 1) {
				oddCount++;
			}

			if (countMap.containsKey(oddCount - k)) {
				count += countMap.get(oddCount - k);
			}

			countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 1, 1 };
		int k = 3;
		System.out.println("Number of nice subarrays with " + k + " odd numbers: " + countNiceSubarrays(nums, k));
	}
}
