package com.softgroup.dsa.matrix;

import java.util.Arrays;

public class MatrixMedian {

	public static double findMedian(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0.0; // Return 0 if the matrix is empty or invalid
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int totalElements = rows * cols;

		int[] flattenedArray = new int[totalElements];

		// Flatten the matrix into a 1D array
		int k = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				flattenedArray[k++] = matrix[i][j];
			}
		}

		// Sort the flattened array
		Arrays.sort(flattenedArray);

		// Determine the median based on whether the total number of elements is even or
		// odd
		if (totalElements % 2 == 0) {
			// If even, return the average of the middle two elements
			int mid1 = flattenedArray[totalElements / 2 - 1];
			int mid2 = flattenedArray[totalElements / 2];
			return (double) (mid1 + mid2) / 2;
		} else {
			// If odd, return the middle element
			return (double) flattenedArray[totalElements / 2];
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };

		double median = findMedian(matrix);
		System.out.println("Median of the matrix: " + median);
	}
}
