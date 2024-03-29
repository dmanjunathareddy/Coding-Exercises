package com.softgroup.dsa.hash;

import java.util.HashMap;

public class EqualSumSwappingPairs {

	public static int[] findPair(int[] arr1, int[] arr2) {
		int sum1 = 0, sum2 = 0;
		for (int num : arr1)
			sum1 += num;
		for (int num : arr2)
			sum2 += num;

		int diff = Math.abs(sum1 - sum2);
		if (diff % 2 != 0)
			return null; // Impossible to make sums equal

		int target = diff / 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : arr2)
			map.put(num, num);

		for (int num1 : arr1) {
			int complement = target + num1;
			if (map.containsKey(complement))
				return new int[] { num1, complement };
		}

		return null; // No valid pair found
	}

	public static void main(String[] args) {
		int[] arr1 = { 4, 1, 2, 1, 1, 2 };
		int[] arr2 = { 3, 6, 3, 3 };

		int[] pair = findPair(arr1, arr2);
		if (pair != null) {
			System.out.println("Pair to swap: " + pair[0] + " from arr1 and " + pair[1] + " from arr2");
		} else {
			System.out.println("No pair found to make sums equal.");
		}
	}
}
