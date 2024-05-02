package com.softgroup.dsa.interview;

public class PalindromeChecker {
	public static boolean isPalindrome(String str) {
		// Remove all non-alphanumeric characters and convert to lowercase
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		// Check if the string is empty or has only one character
		if (str.isEmpty() || str.length() == 1) {
			return true;
		}

		// Compare characters from both ends of the string
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal, Panama!";
		String str2 = "racecar";
		String str3 = "hello";

		System.out.println("Is \"" + str1 + "\" a palindrome? " + isPalindrome(str1));
		System.out.println("Is \"" + str2 + "\" a palindrome? " + isPalindrome(str2));
		System.out.println("Is \"" + str3 + "\" a palindrome? " + isPalindrome(str3));
	}
}
