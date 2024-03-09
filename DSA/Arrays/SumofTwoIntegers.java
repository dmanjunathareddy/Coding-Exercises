package com.softgroup.dsa.arrays;

public class SumofTwoIntegers {
	/*
	 * Given two integers a and b, return the sum of the two integers without using
	 * the operators + and -.
	 */
	public static void main(String[] args) {
		System.out.println(getSum(2, 3));
	}

	public static int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
}
