package com.softgroup.dsa.search;

public class BinarySearch {

	// Function to perform binary search
	public static int binarySearch(int[] arr, int target) {
		int left = 0; // Initialize left index
		int right = arr.length - 1; // Initialize right index

		// Continue while left index is less than or equal to right index
		while (left <= right) {
			// Calculate middle index
			int mid = left + (right - left) / 2;

			// Check if the target element is at the middle index
			if (arr[mid] == target) {
				// Target element found; return its index
				return mid;
			}

			// Check if the target is in the left half of the array
			if (arr[mid] > target) {
				right = mid - 1; // Adjust the search range to the left half
			} else {
				// Target is in the right half of the array
				left = mid + 1; // Adjust the search range to the right half
			}
		}

		// If the loop completes without finding the target, return -1
		return -1;
	}

	public static void main(String[] args) {
		// Example sorted array
		int[] arr = { 1, 3, 4, 6, 7, 8, 9, 11, 15, 18 };

		// Target element to search for
		int target = 9;

		// Perform binary search
		int index = binarySearch(arr, target);

		// Output the result
		if (index != -1) {
			System.out.println("Element " + target + " found at index: " + index);
		} else {
			System.out.println("Element " + target + " not found");
		}
	}
}
