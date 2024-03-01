package com.softgroup.dsa.matrix;

public class MatrixSearch {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0;
		int col = cols - 1;

		while (row < rows && col >= 0) {
			int currentElement = matrix[row][col];

			if (currentElement == target) {
				return true; // Element found
			} else if (currentElement < target) {
				row++;
			} else {
				col--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11 }, { 2, 5, 8, 12 }, { 3, 6, 9, 16 }, { 10, 13, 14, 17 } };
		int target1 = 5;
		int target2 = 15;
		System.out.println("Matrix:");
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + "\t");
			}
			System.out.println();
		}

		System.out.println("Search for " + target1 + ": " + searchMatrix(matrix, target1));
		System.out.println("Search for " + target2 + ": " + searchMatrix(matrix, target2));
	}
}
