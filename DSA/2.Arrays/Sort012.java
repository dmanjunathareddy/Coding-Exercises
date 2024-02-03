package com.softgroup.dsa.array;

public class Sort012 {
	public static void sort012(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 1, 1, 2, 0, 1, 2, 1, 0 };
		sort012(arr);

		// Print the sorted array
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
