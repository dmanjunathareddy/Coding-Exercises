package com.softgroup.dsa.search;

public class FirstLastPositionInSortedArray {

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	private static int findFirst(int[] nums, int target) {
		int index = -1;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				index = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return index;
	}

	private static int findLast(int[] nums, int target) {
		int index = -1;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				index = mid;
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;

		int[] result = searchRange(nums, target);

		System.out.println("First occurrence: " + result[0]);
		System.out.println("Last occurrence: " + result[1]);
	}
}
