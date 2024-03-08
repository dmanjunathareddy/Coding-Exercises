package com.softgroup.dsa.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);

		selectionSort(arr);

		System.out.println("Sorted Array:");
		printArray(arr);
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
