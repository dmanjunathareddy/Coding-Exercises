package com.softgroup.dsa.string;

public class ReverseWords {

	public static void main(String[] args) {
		String input = "Hello World Java Example";
		System.out.println("Original String: " + input);

		String reversedWords = reverseWords(input);
		System.out.println("String with Reversed Words: " + reversedWords);
	}

	public static String reverseWords(String input) {
		String[] words = input.split(" ");
		StringBuilder reversedBuilder = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			reversedBuilder.append(words[i]);
			if (i > 0) {
				reversedBuilder.append(" ");
			}
		}

		return reversedBuilder.toString();
	}
}
