package com.softgroup.dsa.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);

		bubbleSort(arr, arr.length);

		System.out.println("Sorted Array:");
		printArray(arr);
	}

	public static void bubbleSort(int[] arr, int n) {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
