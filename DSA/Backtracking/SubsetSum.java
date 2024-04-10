package com.softgroup.dsa.backtracking;

import java.util.Arrays;

public class SubsetSum {
	public boolean canPartition(int[] nums, int target) {
		Arrays.sort(nums);
		return canPartitionHelper(nums, 0, target);
	}

	private boolean canPartitionHelper(int[] nums, int index, int target) {
		if (target == 0)
			return true;
		if (index >= nums.length || nums[index] > target)
			return false;

		// Include the current number in the subset
		if (canPartitionHelper(nums, index + 1, target - nums[index]))
			return true;

		// Exclude the current number from the subset
		while (index < nums.length - 1 && nums[index] == nums[index + 1])
			index++;
		return canPartitionHelper(nums, index + 1, target);
	}

	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		int[] nums = { 1, 5, 11, 5 };
		int target = 11;
		System.out.println(subsetSum.canPartition(nums, target)); // Output: true
	}
}
