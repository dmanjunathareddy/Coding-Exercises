package com.softgroup.dsa.bitmanipulation;

public class OddEvenChecker {
	public static boolean isOdd(int num) {
		// Check the least significant bit (LSB)
		// If the LSB is 1, the number is odd; otherwise, it's even
		return (num & 1) == 1;
	}

	public static void main(String[] args) {
		int number = 5;
		if (isOdd(number)) {
			System.out.println(number + " is odd.");
		} else {
			System.out.println(number + " is even.");
		}
	}
}
