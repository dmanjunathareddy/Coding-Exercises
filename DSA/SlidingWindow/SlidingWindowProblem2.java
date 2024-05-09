package com.softgroup.dsa.slidingwindowtechnique;

import java.util.HashMap;

public class SlidingWindowProblem2 {
	public static int longestSubstringLength(String s, int k) {
		int maxLength = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while (map.size() > k) {
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0)
					map.remove(leftChar);
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		System.out.println("Length of longest substring with at most " + k + " distinct characters is: "
				+ longestSubstringLength(s, k));
	}
}
