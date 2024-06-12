package com.softgroup.dsa.interview.leetcode;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            // Push the current bar to the stack if it is higher than the bar at the stack's top
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index);
                index++;
            } else {
                // Pop the top of the stack and calculate the area with the popped bar as the smallest bar
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        // Calculate area for the remaining bars in the stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights)); // Output: 10
    }
}
