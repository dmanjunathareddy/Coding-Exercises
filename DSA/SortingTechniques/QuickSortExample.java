package com.softgroup.dsa.sorting;

public class QuickSortExample {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		printArray(arr);
		System.out.println("Original Array:");
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array:");
		printArray(arr);

	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(array, low, high);
			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}
}
