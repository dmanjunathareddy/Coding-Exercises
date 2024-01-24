package com.softgroup.dsa.stack;

import java.util.Stack;

public class ReverseWordsWithStack {

	public static void main(String[] args) {
		String input = "Hello World Java Example";
		System.out.println("Original String: " + input);

		String reversedWords = reverseWords(input);
		System.out.println("String with Reversed Words: " + reversedWords);
	}

	public static String reverseWords(String input) {
		String[] words = input.split(" ");
		Stack<String> wordStack = new Stack<>();
		for (String word : words) {
			wordStack.push(word);
		}
		StringBuilder reversedBuilder = new StringBuilder();
		while (!wordStack.isEmpty()) {
			reversedBuilder.append(wordStack.pop());
			if (!wordStack.isEmpty()) {
				reversedBuilder.append(" ");
			}
		}
		return reversedBuilder.toString();
	}
}
