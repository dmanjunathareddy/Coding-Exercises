package com.softgroup.dsa.array;

import java.util.Stack;

public class BracketBalancer {

	public static int minSwaps(String s) {
		if (s == null || s.isEmpty()) {
			return 0; // If the string is null or empty, no swaps are needed
		}

		Stack<Character> stack = new Stack<>();
		int swaps = 0;

		for (char c : s.toCharArray()) {
			if (c == '[') {
				stack.push(c);
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() == ']') {
					stack.push(c);
				} else if (stack.peek() == '[') {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			char top = stack.pop();
			if (top == '[' && !stack.isEmpty() && stack.peek() == ']') {
				swaps++; // If adjacent brackets are unbalanced, a swap is needed
				stack.pop();
			}
		}

		return swaps;
	}

	public static void main(String[] args) {
		String s = "]]][[[";
		int swaps = minSwaps(s);
		System.out.println("Minimum swaps required for balancing brackets: " + swaps);
	}
}
