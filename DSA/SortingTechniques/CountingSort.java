package com.softgroup.dsa.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void countingSort(int[] array) {
		int max = findMax(array);
		int[] count = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		int[] result = new int[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			result[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}

		System.arraycopy(result, 0, array, 0, array.length);
	}

	private static int findMax(int[] array) {
		int max = array[0];
		for (int value : array) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = { 4, 2, 10, 5, 1 };
		System.out.println("Original Array: " + Arrays.toString(array));

		countingSort(array);

		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}
