package com.softgroup.dsa.arrays;

import java.util.Arrays;

public class KthElementUsingSorting {

	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums); // Sort the array in ascending order
		return nums[nums.length - k]; // Access the Kth largest element from the end
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 }; // Example array
		int k = 2; // Value of k
		int result = findKthLargest(nums, k);
		System.out.println("The " + k + "th largest element is: " + result);
	}
}
