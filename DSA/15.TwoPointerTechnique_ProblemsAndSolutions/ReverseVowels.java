package com.softgroup.dsa.greedy.twopointer;

public class ReverseVowels {

	public static String reverseVowels(String s) {
		char[] charArray = s.toCharArray();
		int left = 0;
		int right = charArray.length - 1;

		while (left < right) {
			while (left < right && !isVowel(charArray[left])) {
				left++;
			}

			while (left < right && !isVowel(charArray[right])) {
				right--;
			}

			if (left < right) {
				// Swap the vowels
				char temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = temp;

				// Move the pointers towards each other
				left++;
				right--;
			}
		}

		return new String(charArray);
	}

	private static boolean isVowel(char ch) {
		return "aeiouAEIOU".indexOf(ch) != -1;
	}

	public static void main(String[] args) {
		String input = "hello world";
		System.out.println("Original String: " + input);

		String result = reverseVowels(input);
		System.out.println("String with reversed vowels: " + result);
	}
}
