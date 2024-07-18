package com.softgroup.dsa.interview.leetcode.top150;

public class SpiralMatrix {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int num = 1;
		int top = 0, bottom = n - 1, left = 0, right = n - 1;

		while (top <= bottom && left <= right) {
			// Fill the top row
			for (int i = left; i <= right; i++) {
				matrix[top][i] = num++;
			}
			top++;

			// Fill the right column
			for (int i = top; i <= bottom; i++) {
				matrix[i][right] = num++;
			}
			right--;

			// Fill the bottom row if within the current boundaries
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					matrix[bottom][i] = num++;
				}
				bottom--;
			}

			// Fill the left column if within the current boundaries
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					matrix[i][left] = num++;
				}
				left++;
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int n = 3; // Example size
		int[][] result = sm.generateMatrix(n);

		// Print the spiral matrix
		for (int[] row : result) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
