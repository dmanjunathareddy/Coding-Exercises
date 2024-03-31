package com.softgroup.dsa.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

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
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println("Largest rectangle area: " + largestRectangleArea(heights));
	}
}
