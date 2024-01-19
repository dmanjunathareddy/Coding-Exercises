package com.softgroup.dsa.string;

public class LargestOddNumber {
	public static void main(String[] args) {
		LargestOddNumber solution = new LargestOddNumber();
		String result = solution.largestOddNumber("35427");
		System.out.println("Largest Odd Number: " + result);
	}

	public String largestOddNumber(String num) {
		int n = num.length();
		for (int i = n - 1; i >= 0; i--) {
			char digit = num.charAt(i);
			if ((digit - '0') % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}
}
