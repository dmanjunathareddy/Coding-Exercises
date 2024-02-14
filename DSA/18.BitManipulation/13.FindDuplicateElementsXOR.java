package com.softgroup.dsa.bitmanipulation;

import java.util.Arrays;

public class FindDuplicateElementsXOR {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2, 2 };
		int[] duplicates = findDuplicates(arr);
		System.out.println("Two duplicate elements are: " + Arrays.toString(duplicates));
	}

	public static int[] findDuplicates(int[] arr) {
		int[] result = new int[2];
		int xorResult = 0;

		for (int num : arr) {
			xorResult ^= num;
		}

		for (int i = 1; i <= arr.length; i++) {
			xorResult ^= i;
		}

		int rightmostSetBit = xorResult & ~(xorResult - 1);

		int group1 = 0, group2 = 0;
		for (int num : arr) {
			if ((num & rightmostSetBit) == 0) {
				group1 ^= num;
			} else {
				group2 ^= num;
			}
		}
		for (int i = 1; i <= arr.length; i++) {
			if ((i & rightmostSetBit) == 0) {
				group1 ^= i;
			} else {
				group2 ^= i;
			}
		}
		result[0] = group1;
		result[1] = group2;

		return result;
	}
}
