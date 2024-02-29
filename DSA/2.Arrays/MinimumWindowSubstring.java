package com.softgroup.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> targetMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		int left = 0; // Left pointer of the window
		int minLen = Integer.MAX_VALUE; // Minimum window length found so far
		int minLeft = 0; // Left index of the minimum window
		int count = 0; // Count of characters in target found in the current window
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);

			if (targetMap.containsKey(c)) {
				targetMap.put(c, targetMap.get(c) - 1);
				if (targetMap.get(c) >= 0) {
					count++;
				}
				while (count == t.length()) {
					// Update minimum window length
					if (right - left + 1 < minLen) {
						minLen = right - left + 1;
						minLeft = left;
					}

					char leftChar = s.charAt(left);
					if (targetMap.containsKey(leftChar)) {
						targetMap.put(leftChar, targetMap.get(leftChar) + 1);
						if (targetMap.get(leftChar) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println("Minimum window substring: " + minWindow(S, T)); // Output: "BANC"
	}
}
