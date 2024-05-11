package com.softgroup.dsa.prefixSumTechnique;

import java.util.Arrays;

public class RearrangeArray {
	public static void rearrange(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0 && arr[i] > arr[i + 1] || i % 2 != 0 && arr[i] < arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 6, 2, 5, 8, 1, 4, 7 };
		rearrange(arr);
		System.out.println("Rearranged array: " + Arrays.toString(arr));
	}
}
