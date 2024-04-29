package com.softgroup.dsa.stack;

import java.util.*;

public class DailyTemperatures {
	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		DailyTemperatures solution = new DailyTemperatures();
		int[] result = solution.dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(result)); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
	}

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}

		return result;
	}
}
