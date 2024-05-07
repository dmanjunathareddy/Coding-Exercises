package com.softgroup.dsa.array;

import java.util.Arrays;

public class CountingSort {
	public static void countingSort(int[] arr) {
		int max = Arrays.stream(arr).max().orElse(0);
		int[] count = new int[max + 1];
		int[] output = new int[arr.length];

		for (int num : arr)
			count[num]++;

		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}

		System.arraycopy(output, 0, arr, 0, arr.length);
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
		System.out.println("Original array: " + Arrays.toString(arr));
		countingSort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}
}
