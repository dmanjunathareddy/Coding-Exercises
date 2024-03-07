package com.softgroup.dsa.dp;

public class MinimumSubsetSumDifference {

	public static int minSubsetSumDiff(int[] arr) {
		int n = arr.length;
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		boolean[] dp = new boolean[totalSum + 1];
		dp[0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = totalSum; j >= arr[i]; j--) {
				dp[j] |= dp[j - arr[i]];
			}
		}
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i <= totalSum / 2; i++) {
			if (dp[i]) {
				minDiff = Math.min(minDiff, totalSum - 2 * i);
			}
		}

		return minDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 11, 5 };
		int minDiff = minSubsetSumDiff(arr);
		System.out.println("Minimum absolute difference of subset sums: " + minDiff);
	}
}
