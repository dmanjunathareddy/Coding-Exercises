package com.softgroup.dsa.bitmanipulation;

public class BitChecker {
	public static boolean isBitSet(int num, int i) {
		// Create a mask with only the i-th bit set
		int mask = 1 << i;
		// Perform bitwise AND operation between the number and the mask
		// If the i-th bit is set, the result will be non-zero
		return (num & mask) != 0;
	}

	public static void main(String[] args) {
		int number = 9; // Binary representation: 1001
		int position = 3; // 0-based index of the bit to check

		if (isBitSet(number, position)) {
			System.out.println("The " + position + "-th bit of " + number + " is set.");
		} else {
			System.out.println("The " + position + "-th bit of " + number + " is not set.");
		}
	}
}
