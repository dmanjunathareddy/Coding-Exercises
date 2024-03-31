package com.softgroup.dsa.stack;

import java.util.Stack;

public class EvaluateRPN {
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (String token : tokens) {
			if (token.equals("+")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				stack.push(operand1 + operand2);
			} else if (token.equals("-")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				stack.push(operand1 - operand2);
			} else if (token.equals("*")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				stack.push(operand1 * operand2);
			} else if (token.equals("/")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				stack.push(operand1 / operand2);
			} else {
				// If token is a number
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		int result = evalRPN(tokens);
		System.out.println("Result: " + result);
	}
}
