package com.softgroup.dsa.string;

public class PalindromeExample {

	public static boolean isPalindrome(String str) {
		// Removing non-alphanumeric characters and converting to lowercase
		str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		// Check if the string is a palindrome
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
		// Example usage
		String palindromeStr = "A man, a plan, a canal, Panama!";
		boolean isPalindromeResult = isPalindrome(palindromeStr);

		if (isPalindromeResult) {
			System.out.println("'" + palindromeStr + "' is a palindrome.");
		} else {
			System.out.println("'" + palindromeStr + "' is not a palindrome.");
		}
	}
}
