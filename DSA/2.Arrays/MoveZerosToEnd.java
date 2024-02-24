package com.softgroup.dsa.leetcode75;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] arr = { 4, 0, 7, 6, 0, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);
		moveZeros(arr, arr.length);
		System.out.println("Sorted Array:");
		printArray(arr);

	}

	public static int[] moveZeros(int[] a, int n) {
		int nonZeroCount = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != 0) {
				int temp = a[i];
				a[i] = a[nonZeroCount];
				a[nonZeroCount] = temp;
				nonZeroCount++;
			}
		}
		return a;
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
