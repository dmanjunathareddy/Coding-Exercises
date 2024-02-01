package com.softgroup.dsa.array;

public class KadanesAlgorithm {

	public static int maxSubArraySum(int[] arr) {
		int maxEndingHere = arr[0];
		int maxSoFar = arr[0];

		for (int i = 1; i < arr.length; i++) {
			maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum subarray sum: " + maxSubArraySum(arr));
	}
}
