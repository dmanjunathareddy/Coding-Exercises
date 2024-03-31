package com.softgroup.dsa.stack;

import java.util.Stack;

public class DecodeString {

	public static String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int count = 0;

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				count = count * 10 + (ch - '0');
			} else if (ch == '[') {
				countStack.push(count);
				stringStack.push(currentString);
				currentString = new StringBuilder();
				count = 0;
			} else if (ch == ']') {
				StringBuilder temp = currentString;
				currentString = stringStack.pop();
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					currentString.append(temp);
				}
			} else {
				currentString.append(ch);
			}
		}

		return currentString.toString();
	}

	public static void main(String[] args) {
		String encodedString = "3[a]2[bc]";
		String decodedString = decodeString(encodedString);
		System.out.println("Decoded string: " + decodedString);
	}
}
