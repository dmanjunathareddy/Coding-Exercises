package com.softgroup.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		backtrack(nums, results, new ArrayList<>(), 0);
		return results;
	}

	private void backtrack(int[] nums, List<List<Integer>> results, List<Integer> current, int start) {
		// Add the current subset to the results
		results.add(new ArrayList<>(current));

		// Iterate through the array to explore subsets
		for (int i = start; i < nums.length; i++) {
			// Add the current element to the current subset
			current.add(nums[i]);
			// Recursively backtrack with the next element
			backtrack(nums, results, current, i + 1);
			// Remove the current element to backtrack
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> results = subsets.subsets(nums);
		for (List<Integer> subset : results) {
			System.out.println(subset);
		}
	}
}
