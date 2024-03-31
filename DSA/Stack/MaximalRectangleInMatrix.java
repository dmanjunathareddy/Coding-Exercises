package com.softgroup.dsa.stack;

import java.util.Stack;

public class MaximalRectangleInMatrix {

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int maxArea = 0;
		int[] heights = new int[matrix[0].length];

		for (int row = 0; row < matrix.length; row++) {
			// Calculate heights array for current row
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == '1') {
					heights[col]++;
				} else {
					heights[col] = 0; // Reset height to 0 if encountered 0
				}
			}
			// Calculate max rectangle area for current row using the heights array
			maxArea = Math.max(maxArea, largestRectangleArea(heights));
		}

		return maxArea;
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int top = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, heights[top] * width);
			}
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
			maxArea = Math.max(maxArea, heights[top] * width);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println("Maximal rectangle area: " + maximalRectangle(matrix));
	}
}
