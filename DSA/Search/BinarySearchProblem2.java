package com.softgroup.dsa.binarysearch;

public class BinarySearchProblem2 {
	public static int countOccurrences(int[] arr, int target) {
		int firstOccurrence = firstIndex(arr, target);
		if (firstOccurrence == -1)
			return 0;
		int lastOccurrence = lastIndex(arr, target);
		return lastOccurrence - firstOccurrence + 1;
	}

	private static int firstIndex(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target)
				left = mid + 1;
			else if (arr[mid] > target)
				right = mid - 1;
			else {
				if (mid == 0 || arr[mid - 1] != target)
					return mid;
				else
					right = mid - 1;
			}
		}
		return -1;
	}

	private static int lastIndex(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target)
				left = mid + 1;
			else if (arr[mid] > target)
				right = mid - 1;
			else {
				if (mid == arr.length - 1 || arr[mid + 1] != target)
					return mid;
				else
					left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 3, 4, 5, 5, 6 };
		int target = 2;
		int count = countOccurrences(arr, target);
		System.out.println("Occurrences of " + target + " is: " + count);
	}
}
