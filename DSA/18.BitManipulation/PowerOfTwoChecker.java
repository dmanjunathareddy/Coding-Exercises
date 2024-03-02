package com.softgroup.dsa.bitmanipulation;

public class PowerOfTwoChecker {
	public static boolean isPowerOfTwo(int num) {
		return num > 0 && (num & (num - 1)) == 0;
	}

	public static void main(String[] args) {
		int number = 16;
		if (isPowerOfTwo(number)) {
			System.out.println(number + " is a power of 2.");
		} else {
			System.out.println(number + " is not a power of 2.");
		}
	}
}
