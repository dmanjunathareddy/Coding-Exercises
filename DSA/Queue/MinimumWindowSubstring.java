package com.softgroup.dsa.queue;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		// Check for edge cases
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return "";
		}

		// Initialize maps to store character frequencies
		Map<Character, Integer> targetFreq = new HashMap<>();
		for (char c : t.toCharArray()) {
			targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowFreq = new HashMap<>();

		int requiredChars = targetFreq.size(); // Number of distinct characters to match
		int formedChars = 0; // Number of distinct characters formed in the window
		int left = 0; // Left pointer of the sliding window
		int right = 0; // Right pointer of the sliding window
		int minLength = Integer.MAX_VALUE; // Length of the minimum window
		int minLeft = 0; // Left pointer of the minimum window

		while (right < s.length()) {
			char currentChar = s.charAt(right);
			windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

			// Update the formed characters count if the current character's frequency
			// matches the target frequency
			if (targetFreq.containsKey(currentChar)
					&& windowFreq.get(currentChar).intValue() == targetFreq.get(currentChar).intValue()) {
				formedChars++;
			}

			// Try to minimize the window by advancing the left pointer
			while (left <= right && formedChars == requiredChars) {
				// Update the minimum window if a smaller one is found
				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					minLeft = left;
				}

				// Shrink the window from the left
				char leftChar = s.charAt(left);
				windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
				if (targetFreq.containsKey(leftChar)
						&& windowFreq.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
					formedChars--;
				}
				left++;
			}

			right++; // Expand the window from the right
		}

		// If minLength is still Integer.MAX_VALUE, no valid window found
		return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t)); // Output: "BANC"
	}
}
