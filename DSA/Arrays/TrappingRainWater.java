package com.softgroup.dsa.arrays;

public class TrappingRainWater {
	public static int trap(int[] height) {
		int n = height.length;
		if (n <= 2) {
			return 0; // Not enough walls to trap water
		}

		int[] leftMax = new int[n]; // Array to store the maximum height to the left of each wall
		int[] rightMax = new int[n]; // Array to store the maximum height to the right of each wall

		// Calculate leftMax array
		leftMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		// Calculate rightMax array
		rightMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		// Calculate trapped water for each wall
		int totalWater = 0;
		for (int i = 0; i < n; i++) {
			int minHeight = Math.min(leftMax[i], rightMax[i]);
			totalWater += minHeight - height[i];
		}

		return totalWater;
	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Trapped water: " + trap(height)); // Output: 6
	}
}
