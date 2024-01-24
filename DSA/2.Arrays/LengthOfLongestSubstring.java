package com.softgroup.dsa.leetcode75;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String str = "Manjunatha";
		System.out.println("max length is  ->" + lengthOfLongestSubstring(str));
	}

	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;
		char[] ch = s.toCharArray();
		int n = ch.length;

		int maxLength = 0;
		Set<Character> charSet = new HashSet<Character>();

		while (right < n) {
			if (!charSet.contains(ch[right])) {
				charSet.add(ch[right]);
				right++;
				maxLength = Math.max(maxLength, right - left);
			} else {
				charSet.remove(s.charAt(left));
				left++;
			}

		}
		return maxLength;

	}
}