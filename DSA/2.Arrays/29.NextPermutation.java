package com.softgroup.dsa.arrays;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		int k = nums.length - 2;
		while (k >= 0 && nums[k] >= nums[k + 1]) {
			k--;
		}
		if (k == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int l = nums.length - 1;
		while (nums[l] <= nums[k]) {
			l--;
		}
		swap(nums, k, l);
		reverse(nums, k + 1, nums.length - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		nextPermutation(nums);
		System.out.println("Next permutation: " + Arrays.toString(nums));
	}
}
