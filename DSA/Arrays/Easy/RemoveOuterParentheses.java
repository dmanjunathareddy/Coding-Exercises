package com.softgroup.dsa.string;

public class RemoveOuterParentheses {
	public String removeOuterParentheses(String s) {
		StringBuilder result = new StringBuilder();
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(' && count++ > 0) {
				result.append(c);
			} else if (c == ')' && --count > 0) {
				result.append(c);
			} else if (count > 1) {
				result.append(c);
			}
		}
		return result.toString();
	}
}