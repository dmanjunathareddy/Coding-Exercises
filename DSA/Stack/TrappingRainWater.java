package com.softgroup.dsa.stack;

import java.util.Stack;

public class TrappingRainWater {

	public static int trap(int[] height) {
		int n = height.length;
		if (n == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();
		int waterTrapped = 0;

		for (int i = 0; i < n; i++) {
			// While stack is not empty and current height is greater than the height at the
			// top of stack
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int top = stack.pop(); // Current top of the stack
				if (stack.isEmpty())
					break; // No left boundary to hold water
				int distance = i - stack.peek() - 1; // Width of the potential container
				int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top]; // Height of the potential
																								// container
				waterTrapped += distance * boundedHeight; // Add trapped water volume
			}
			stack.push(i);
		}

		return waterTrapped;
	}

	public static void main(String[] args) {
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Total water trapped: " + trap(heights));
	}
}
