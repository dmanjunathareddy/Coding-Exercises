package com.softgroup.dsa.sorting;

import java.util.Arrays;

public class RadixSort {
	private static int getMax(int[] array) {
		int max = array[0];
		for (int value : array) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	private static void countingSort(int[] array, int exp) {
		int n = array.length;
		int[] output = new int[n];
		int[] count = new int[10];

		Arrays.fill(count, 0);

		for (int i = 0; i < n; i++) {
			count[(array[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		}
		System.arraycopy(output, 0, array, 0, n);
	}

	public static void radixSort(int[] array) {
		int max = getMax(array);
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(array, exp);
		}
	}

	public static void main(String[] args) {
		int[] array = { 170, 45, 75, 90, 802, 24, 2, 66 };
		System.out.println("Original Array: " + Arrays.toString(array));
		radixSort(array);
		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}
