package com.softgroup.dsa.heap;

public class HeapSort {

	public static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int heapSize, int i) {
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
			largest = leftChild;
		}
		if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
			largest = rightChild;
		}
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, heapSize, largest);
		}
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original array:");
		printArray(arr);
		heapSort(arr);
		System.out.println("Sorted array:");
		printArray(arr);
	}
}
