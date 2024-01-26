package com.softgroup.patterns;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 5, 6, 12, 4, 3 };
		int target = 15;
		System.out.println(twoSumBruteForce(nums, target));
		System.out.println(twoSumOptimal(nums, target));
		int[] twoSum = twoSum(nums, target);
		for (int i = 0; i < twoSum.length; i++) {
			System.out.println(twoSum[i]);

		}
	}

	// BruteForce approach with O(N*2)
	private static boolean twoSumBruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return true;
				}
			}
		}
		return false;
	}

	// Two pointer approach with o(nlogN)
	private static boolean twoSumOptimal(int[] nums, int target) {
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int sum = nums[low] + nums[high];
			if (sum == target) {
				return true;
			} else if (sum > target) {
				high--;
			} else if (sum < target) {
				low++;
			}
		}
		return false;
	}

	// Two pointer approach with o(n) but extra space
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		return new int[0]; // No solution found
	}

}