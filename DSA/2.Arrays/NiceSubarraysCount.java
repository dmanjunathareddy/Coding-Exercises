package com.softgroup.dsa.arrays;

public class NiceSubarraysCount {
	public static int countNiceSubarrays(int[] nums, int k) {
		int count = 0;
		int oddCount = 0;
		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			if (nums[right] % 2 == 1) {
				oddCount++;
			}

			while (oddCount > k) {
				if (nums[left] % 2 == 1) {
					oddCount--;
				}
				left++;
			}

			count += right - left + 1;

		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 1, 1 };
		int k = 2;
		System.out.println("Number of nice subarrays: " + countNiceSubarrays(nums, k)); // Output: 4
	}
}
