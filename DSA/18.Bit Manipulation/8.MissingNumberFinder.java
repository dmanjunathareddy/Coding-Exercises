package com.softgroup.dsa.bitmanipulation;

public class MissingNumberFinder {
	public static int findMissingNumber(int[] nums) {
		int missingNumber = nums.length + 1;
		for (int i = 0; i < nums.length; i++) {
			missingNumber ^= (i + 1) ^ nums[i];
		}
		return missingNumber;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6 }; // Example array with a missing number
		int missingNumber = findMissingNumber(arr);
		System.out.println("The missing number is: " + missingNumber);
	}
}
