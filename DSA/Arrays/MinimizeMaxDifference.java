package com.softgroup.dsa.array;

import java.util.Arrays;

public class MinimizeMaxDifference {

	public static int minimizeMaxDifference(int[] heights, int k) {
		Arrays.sort(heights);
		int n = heights.length;
		int minDifference = Integer.MAX_VALUE;
		for (int i = 0; i <= n - k; i++) {
			int currentDifference = heights[i + k - 1] - heights[i];
			minDifference = Math.min(minDifference, currentDifference);
		}
		return minDifference;
	}

	public static void main(String[] args) {
		int[] heights = { 1, 15, 10 };
		int k = 2;
		int minMaxDifference = minimizeMaxDifference(heights, k);
		System.out.println("Minimum maximum difference between heights: " + minMaxDifference);
	}
}
