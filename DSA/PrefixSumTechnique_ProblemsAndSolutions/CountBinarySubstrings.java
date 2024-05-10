package com.softgroup.dsa.prefixSumTechnique;

public class CountBinarySubstrings {
	public static int countBinarySubstrings(String s) {
		int current = 1;
		int prev = 0;
		int count = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				current++;
			else {
				count += Math.min(prev, current);
				prev = current;
				current = 1;
			}
		}

		return count + Math.min(prev, current);
	}

	public static void main(String[] args) {
		String s = "00110011";
		System.out.println(
				"Number of substrings with equal number of consecutive '0's and '1's is: " + countBinarySubstrings(s));
	}
}
