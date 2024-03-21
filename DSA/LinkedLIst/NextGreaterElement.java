package com.softgroup.dsa.array;

import java.util.*;

public class NextGreaterElement {
	public static int[] nextGreaterElement(int[] nums) {
		int[] result = new int[nums.length];
		Arrays.fill(result, -1); // Initialize result array with -1

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				int index = stack.pop();
				result[index] = nums[i];
			}
			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 4, 7, 8, 1, 2, 4 };
		int[] result = nextGreaterElement(nums);

		System.out.println("Input array: " + Arrays.toString(nums));
		System.out.println("Next greater elements: " + Arrays.toString(result));
	}
}
