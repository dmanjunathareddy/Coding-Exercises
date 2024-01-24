package com.softgroup.dsa.leetcode75;

public class ThirdLargestNumber {

	public static void main(String[] args) {

		int[] nums = { 4, 5, 3, 2, 1 };

		System.out.println(thirdMax(nums));
	}

	public static int thirdMax(int[] nums) {
		long first = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;
		if (nums.length < 3) {
			if (nums.length < 2) {
				return nums[0];
			} else {
				return Math.max(nums[0], nums[1]);
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > first) {
					third = second;
					second = first;
					first = nums[i];
				} else if (nums[i] > second && nums[i] < first) {
					third = second;
					second = nums[i];
				} else if (nums[i] > third && nums[i] < second) {
					third = nums[i];
				}
			}
			return (int) (third != Long.MIN_VALUE ? third : first);

		}

	}

}
