package com.softgroup.dsa.array;

public class NextGreatestPalindromicNumber {
	public static long findNextPalindrome(long num) {
		boolean isPalindrome = false;
		while (!isPalindrome) {
			num++;
			if (isPalindrome(num)) {
				isPalindrome = true;
			}
		}
		return num;
	}

	public static boolean isPalindrome(long num) {
		long reverse = 0;
		long originalNum = num;
		while (num > 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return originalNum == reverse;
	}

	public static void main(String[] args) {
		long num = 543212345;
		long nextPalindrome = findNextPalindrome(num);
		System.out.println("Next greatest palindromic number after " + num + " is: " + nextPalindrome);
	}
}
