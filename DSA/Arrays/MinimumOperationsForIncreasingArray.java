package com.softgroup.dsa.array;

public class MinimumOperationsForIncreasingArray {
	public static int minOperations(int[] nums) {
		int operations = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= nums[i - 1]) {
				operations += nums[i - 1] - nums[i] + 1;
				nums[i] = nums[i - 1] + 1;
			}
		}

		return operations;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 6, 5, 4 };
		System.out.println("Minimum operations required: " + minOperations(nums));
	}
}
