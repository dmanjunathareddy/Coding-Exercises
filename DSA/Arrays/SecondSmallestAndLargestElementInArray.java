package com.softgroup.dsa.arrays;

public class SecondSmallestAndLargestElementInArray {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		// int[] arr = { 1, 111, 11, 111111, 1111, 11111, 1111111 };
		printArray(getSecondOrderElements(arr.length, arr));

	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static int[] getSecondOrderElements(int n, int[] a) {
		int[] result = new int[2];
		int secondLargest = findsecondLargest(n, a);
		int secondSmalest = findsecondSmalest(n, a);
		result[0] = secondLargest;
		result[1] = secondSmalest;
		return result;
	}

	public static int findsecondLargest(int n, int[] a) {
		if (n < 2) {
			return -1;
		}
		int secondLargest = Integer.MIN_VALUE;
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (largest < a[i]) {
				secondLargest = largest;
				largest = a[i];
			} else if (largest != a[i] && secondLargest < a[i]) {
				secondLargest = a[i];
			}

		}
		return secondLargest;
	}

	private static int findsecondSmalest(int n, int[] a) {

		if (n < 2) {
			return -1;
		}
		int secondSmalest = Integer.MAX_VALUE;
		int smalest = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (smalest > a[i]) {
				secondSmalest = smalest;
				smalest = a[i];
			} else if (smalest != a[i] && secondSmalest > a[i]) {
				secondSmalest = a[i];
			}

		}
		return secondSmalest;
	}

}
