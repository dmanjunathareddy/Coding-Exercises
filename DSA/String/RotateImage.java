package com.softgroup.dsa.string;

import java.util.Arrays;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// Reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage rotateImage = new RotateImage();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateImage.rotate(matrix);
		System.out.println("Rotated Image:");
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
