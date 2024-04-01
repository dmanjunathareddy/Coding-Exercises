package com.softgroup.dsa.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExpressionEvaluation {

	public static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evaluatePostfix(postfix);
	}

	public static String infixToPostfix(String expression) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char ch : expression.toCharArray()) {
			if (Character.isDigit(ch)) {
				postfix.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				if (!stack.isEmpty())
					stack.pop(); // Remove '('
			} else { // Operator
				while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	public static int evaluatePostfix(String postfix) {
	    Stack<Integer> stack = new Stack<>();

	    for (char ch : postfix.toCharArray()) {
	        if (Character.isDigit(ch)) {
	            stack.push(ch - '0');
	        } else {
	            if (stack.size() < 2) {
	                System.err.println("Error: Insufficient operands for operator.");
	                return Integer.MIN_VALUE; // or throw an exception
	            }
	            int operand2 = stack.pop();
	            int operand1 = stack.pop();
	            int result = applyOperator(ch, operand1, operand2);
	            stack.push(result);
	        }
	    }

	    if (stack.size() != 1) {
	        System.err.println("Error: Invalid postfix expression.");
	        return Integer.MIN_VALUE; // or throw an exception
	    }

	    return stack.pop();
	}


	public static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static int applyOperator(char op, int a, int b) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			throw new IllegalArgumentException("Invalid operator: " + op);
		}
	}

	public static void main(String[] args) {
		String expression = "2 * (3 + 4) - 5";
		int result = evaluate(expression);
		System.out.println("Result: " + result);
	}
}
