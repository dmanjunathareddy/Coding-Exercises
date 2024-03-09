package com.softgroup.dsa.leetcode75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 1 };
		System.out.println(checkDuplicate(nums));
		System.out.println(checkDuplicateWithSortingTechnique(nums));
		System.out.println(checkDuplicateWithExtraSpace(nums));
	}

	public static boolean checkDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// With sorting
	public static boolean checkDuplicateWithSortingTechnique(int[] nums) {
		Arrays.sort(nums);
		boolean containsDuplicate = false;
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length) {
				if (nums[i] == nums[i + 1]) {
					containsDuplicate = true;
					break;
				}
			}
		}
		return containsDuplicate;
	}

	// With extra space
	public static boolean checkDuplicateWithExtraSpace(int[] nums) {
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashset.contains(nums[i])) {
				return true;
			} else {
				hashset.add(nums[i]);
			}
		}
		return false;
	}

}
