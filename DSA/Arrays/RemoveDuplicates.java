package com.softgroup.dsa.arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 8, 8, };
		int newLength = removeDuplicates(arr);
		System.out.println("New Length: " + newLength);
		System.out.print("Modified Array: ");
		for (int i = 0; i < newLength; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int removeDuplicates(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int uniqueIndex = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[uniqueIndex]) {
				uniqueIndex++;
				arr[uniqueIndex] = arr[i];
			}
		}
		return uniqueIndex + 1;
	}
}
