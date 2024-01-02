package com.softgroup.dsa.stack;

import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		String input = "ManjunthaReddy";
		System.out.println(reverse(input));
	}

	public static String reverse(String S) {
		String result = "";
		Stack<Character> st = new Stack<Character>();
		char[] ch = S.toCharArray();
		for (char c : ch) {
			st.push(c);
		}
		while (!st.isEmpty()) {
			result = result + st.pop();
		}
		return result;

	}

}