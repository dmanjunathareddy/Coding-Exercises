package com.softgroup.dsa.stack;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();

		String s1 = "()[]{}";
		System.out.println("Is \"" + s1 + "\" valid? " + solution.isValid(s1));

		String s2 = "([)]";
		System.out.println("Is \"" + s2 + "\" valid? " + solution.isValid(s2));
	}
}
