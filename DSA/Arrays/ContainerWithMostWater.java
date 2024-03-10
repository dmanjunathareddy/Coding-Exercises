package com.softgroup.dsa.arrays;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int minHeight = Math.min(height[left], height[right]);
			int width = right - left;
			int area = minHeight * width;
			maxArea = Math.max(maxArea, area);

			// Move the pointer with the smaller height towards the other pointer
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("Maximum area: " + maxArea(height)); // Output: 49
	}
}
