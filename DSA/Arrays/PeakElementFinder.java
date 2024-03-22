package com.softgroup.dsa.array;

public class PeakElementFinder {
	public static int findPeakElement(int[] nums) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int peakIndex = findPeakElement(nums);
		System.out.println("Peak element index: " + peakIndex);
		System.out.println("Peak element value: " + nums[peakIndex]);
	}
}
