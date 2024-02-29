package com.softgroup.dsa.string;

import java.util.Stack;

public class BracketReversal {

	public static int countMinReversals(String brackets) {
		int length = brackets.length();
		if (length % 2 != 0) {
			return -1;
		}

		Stack<Character> stack = new Stack<>();
		for (char bracket : brackets.toCharArray()) {
			if (bracket == '{') {
				stack.push(bracket);
			} else {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(bracket);
				}
			}
		}

		int unbalancedCount = 0;
		while (!stack.isEmpty()) {
			char top = stack.pop();
			if (top == '{') {
				unbalancedCount++;
			} else {
				unbalancedCount++;
			}
		}

		return (unbalancedCount + 1) / 2;
	}

	public static void main(String[] args) {
		String brackets = "{{{{}}}}}}";
		int minReversals = countMinReversals(brackets);
		if (minReversals != -1) {
			System.out.println("Minimum number of bracket reversals needed: " + minReversals);
		} else {
			System.out.println("The given string of brackets cannot be balanced.");
		}
	}
}
