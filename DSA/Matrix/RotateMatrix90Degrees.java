package com.softgroup.dsa.matrix;

public class RotateMatrix90Degrees {

	public static void rotateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		transpose(matrix);
		reverseRows(matrix);
	}

	private static void transpose(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = i + 1; j < cols; j++) {
				// Swap elements at (i, j) and (j, i)
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private static void reverseRows(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			int left = 0;
			int right = cols - 1;

			while (left < right) {
				// Swap elements at (i, left) and (i, right)
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;

				left++;
				right--;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		rotateMatrix(matrix);

		System.out.println("Matrix after rotating 90 degrees:");
		printMatrix(matrix);
	}
}
