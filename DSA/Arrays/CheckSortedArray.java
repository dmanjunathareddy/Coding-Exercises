package com.softgroup.dsa.arrays;

/*Problem statement
You have been given an array ‘a’ of ‘n’ non-negative integers.
You have to check whether the given array is sorted in the non-decreasing order or not.
Your task is to return 1 if the given array is sorted. Else, return 0.
*/

public class CheckSortedArray {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println(isSorted(arr.length, arr));
	}

	public static int isSorted(int n, int[] a) {
		for (int i = 1; i < n; i++) {
			if (a[i - 1] > a[i]) {
				return 0;
			}
		}
		return 1;
	}
}
