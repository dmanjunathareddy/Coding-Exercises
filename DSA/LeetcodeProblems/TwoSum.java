package com.softgroup.dsa.leetcode75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		try {
			int[] result = twoSum(nums, target);
			System.out.println(
					"Indices of the two numbers that add up to the target: [" + result[0] + ", " + result[1] + "]");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int cur = nums[i];
			int x = target - cur;
			if (map.containsKey(x)) {
				return new int[] { map.get(x), i };
			}
			map.put(cur, i);
		}

		return null;

	}

}
