package com.softgroup.dsa.string;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {

	public static int longestRepeatingSubstring(String s) {
		int n = s.length(); // Length of the string

		// Define binary search range
		int left = 1; // Minimum length of substring
		int right = n; // Maximum length of substring

		int longestLength = 0; // To track the longest repeating substring length

		// Binary search to find the maximum length of a repeating substring
		while (left <= right) {
			int mid = left + (right - left) / 2; // Calculate the mid point

			// Check if there is a repeating substring of length 'mid'
			if (hasRepeatingSubstring(s, mid)) {
				// If yes, search for longer lengths
				longestLength = mid;
				left = mid + 1;
			} else {
				// If no, search for shorter lengths
				right = mid - 1;
			}
		}

		return longestLength;
	}

	// Function to check if there is a repeating substring of length 'len' in 's'
	private static boolean hasRepeatingSubstring(String s, int len) {
		int n = s.length();

		// Use a hash set to track the substrings
		Set<String> seen = new HashSet<>();

		// Iterate through the string and check each substring of length 'len'
		for (int i = 0; i <= n - len; i++) {
			// Extract the substring of length 'len'
			String substring = s.substring(i, i + len);

			// Check if the substring is already in the set
			if (seen.contains(substring)) {
				return true; // Repeating substring found
			}

			// Add the substring to the set
			seen.add(substring);
		}

		return false; // No repeating substring found
	}

	public static void main(String[] args) {
		// Test the function with some examples
		String s1 = "abcdabcd";
		System.out.println("Longest repeating substring length in \"" + s1 + "\": " + longestRepeatingSubstring(s1)); // Output:
																														// 4

		String s2 = "banana";
		System.out.println("Longest repeating substring length in \"" + s2 + "\": " + longestRepeatingSubstring(s2)); // Output:
																														// 3
	}
}
