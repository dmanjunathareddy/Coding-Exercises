package com.softgroup.dsa.arrays;

/*Coding ninjas problem*/
public class LargestElementInTheArray {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 23, 4, 45, 65, 44, 333, -1 };
		System.out.println("Longest element in the given array is -> " + largestElement(arr, arr.length));
	}

	static int largestElement(int[] arr, int n) {
		int largestElement = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (largestElement < arr[i]) {
				largestElement = arr[i];
			}
		}
		return largestElement;
	}
}
