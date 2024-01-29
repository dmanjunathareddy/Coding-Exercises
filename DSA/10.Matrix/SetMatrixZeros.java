package com.softgroup.dsa.matrix;

public class SetMatrixZeros {

	public static void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean[] zeroRows = new boolean[rows];
		boolean[] zeroCols = new boolean[cols];

		// Identify rows and columns containing zeros
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}

		// Set zeros in identified rows
		for (int i = 0; i < rows; i++) {
			if (zeroRows[i]) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// Set zeros in identified columns
		for (int j = 0; j < cols; j++) {
			if (zeroCols[j]) {
				for (int i = 0; i < rows; i++) {
					matrix[i][j] = 0;
				}
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
		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		setZeroes(matrix);

		System.out.println("Matrix after setting zeros:");
		printMatrix(matrix);
	}
}
