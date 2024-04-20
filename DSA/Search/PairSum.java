package com.softgroup.dsa.search;

import java.util.HashSet;

public class PairSum {

	// Function to find a pair of elements that sum up to target
	public static boolean hasPairSum(int[] arr, int target) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : arr) {
			int complement = target - num;
			if (set.contains(complement)) {
				return true; // Pair found
			}
			set.add(num);
		}
		return false; // Pair not found
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 7, 11, 15 };
		int target = 9;

		boolean result = hasPairSum(arr, target);

		if (result) {
			System.out.println("There exists a pair of elements in the array that sum up to " + target);
		} else {
			System.out.println("No such pair exists in the array.");
		}
	}
}
