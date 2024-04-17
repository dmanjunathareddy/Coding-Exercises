package com.softgroup.dsa.greedy.twopointer;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0; // Pointer for the last unique element

		for (int j = 1; j < nums.length; j++) {
			// If nums[j] is different from nums[i], update nums[i + 1] with nums[j]
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}

		// Return the new length of the array (number of unique elements)
		return i + 1;
	}

	// Example usage
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 4, 5 };
		int newLength = removeDuplicates(nums);
		System.out.println("New length of the array: " + newLength);
		System.out.print("Array with duplicates removed: ");
		for (int i = 0; i < newLength; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
