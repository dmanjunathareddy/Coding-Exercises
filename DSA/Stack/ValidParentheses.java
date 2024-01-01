package com.softgroup.patterns;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String input = "(())";
		System.out.println(input + " is Valid Parentheses? =>" + isValid(input));
	}

	private static boolean isValid(String input) {

		int n = input.length();
		if (n % 2 == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		char[] ch = input.toCharArray();
		for (char c : ch) {
			if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '(') {
				stack.push(')');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
