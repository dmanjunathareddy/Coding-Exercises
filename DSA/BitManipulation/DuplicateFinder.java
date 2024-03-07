package com.softgroup.dsa.bitmanipulation;

public class DuplicateFinder {
	public static int findDuplicate(int[] nums) {
		int n = nums.length - 1;
		int xor1toN = 0;
		for (int i = 1; i <= n; i++) {
			xor1toN ^= i;
		}

		int xorNums = 0;
		for (int num : nums) {
			xorNums ^= num;
		}

		return xor1toN ^ xorNums;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 4 }; // Example array with a duplicate element
		int duplicate = findDuplicate(arr);
		System.out.println("The duplicate element is: " + duplicate);
	}
}
