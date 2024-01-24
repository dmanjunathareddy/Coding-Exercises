package com.softgroup.dsa.sorting;

public class InsertSorting {
	public static void main(String[] args) {

		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);

		insertionSort(arr, arr.length);

		System.out.println("Sorted Array:");
		printArray(arr);

	}

	private static void insertionSort(int[] arr, int length) {

		for (int i = 0; i <= length - 1; i++) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;
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
