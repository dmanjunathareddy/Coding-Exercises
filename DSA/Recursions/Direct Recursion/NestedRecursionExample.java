package com.softgroup.dsa.recursion;

public class NestedRecursionExample {
	public static int ackermann(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return ackermann(m - 1, 1);
		} else {
			return ackermann(m - 1, ackermann(m, n - 1)); // Nested recursion
		}
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		System.out.println("Ackermann of (" + m + ", " + n + ") is: " + ackermann(m, n));
	}
}
