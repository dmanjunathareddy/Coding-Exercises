package com.softgroup.patterns;

public class MaxMinPairwiseComparison {

	static class Pair {
		int min;
		int max;
	}

	public static Pair findMinMax(int[] arr) {
		Pair pair = new Pair();
		int n = arr.length;

		// Initialize min and max to the first element of the array
		pair.min = arr[0];
		pair.max = arr[0];

		// If the array has an odd number of elements, compare the first element with
		// itself.
		// Otherwise, it will be included in the loop below.
		int start = 1;

		// Compare elements in pairs (two at a time)
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				pair.max = arr[0];
				pair.min = arr[1];
			} else {
				pair.max = arr[1];
				pair.min = arr[0];
			}
			start = 2;
		}

		for (int i = start; i < n - 1; i += 2) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > pair.max) {
					pair.max = arr[i];
				}
				if (arr[i + 1] < pair.min) {
					pair.min = arr[i + 1];
				}
			} else {
				if (arr[i + 1] > pair.max) {
					pair.max = arr[i + 1];
				}
				if (arr[i] < pair.min) {
					pair.min = arr[i];
				}
			}
		}

		return pair;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 8, 6, 9, 5};
		Pair pair = findMinMax(arr);

		System.out.println("Maximum: " + pair.max);
		System.out.println("Minimum: " + pair.min);
	}
}
