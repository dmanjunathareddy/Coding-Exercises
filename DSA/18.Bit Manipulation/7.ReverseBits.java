package com.softgroup.dsa.bitmanipulation;

public class ReverseBits {
	public static int reverseBits(int n) {
		int reversed = 0;
		for (int i = 0; i < 32; i++) {
			reversed <<= 1;
			reversed |= (n & 1);
			n >>= 1;
		}
		return reversed;
	}

	public static void main(String[] args) {
		int number = 43261596; // Example number
		System.out.println("Original number: " + Integer.toBinaryString(number));
		int reversed = reverseBits(number);
		System.out.println("Reversed number: " + Integer.toBinaryString(reversed));
	}
}
