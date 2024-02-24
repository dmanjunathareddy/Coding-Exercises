package com.softgroup.dsa.arrays;

public class MaxOccurringCharacter {
	public static char maxOccurringChar(String str) {
		int[] count = new int[26];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		char maxChar = 'a';
		for (char c = 'b'; c <= 'z'; c++) {
			if (count[c - 'a'] > count[maxChar - 'a']) {
				maxChar = c;
			}
		}

		return maxChar;
	}

	public static void main(String[] args) {
		String str = "aabbbccc";
		System.out.println("Maximum occurring character: " + maxOccurringChar(str));
	}
}
