package com.softgroup.dsa.sorting;

public class RecursiveBubbleSort {

	public static void main(String args[]) {

		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);

		bubble_sort(arr, arr.length);

		System.out.println("Sorted Array:");
		printArray(arr);

	}

	static void bubble_sort(int[] arr, int n) {
		if (n == 1)
			return;
		for (int j = 0; j <= n - 2; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		bubble_sort(arr, n - 1);

	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
