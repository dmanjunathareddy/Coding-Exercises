package com.softgroup.dsa.array;

public class ArrayRotation {
	public static void rotateArray(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return; // No need to rotate if array is null or has 1 element
		}

		int lastElement = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = lastElement;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };

		System.out.println("Original array:");
		printArray(arr);

		rotateArray(arr);

		System.out.println("Array after cyclic rotation:");
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
