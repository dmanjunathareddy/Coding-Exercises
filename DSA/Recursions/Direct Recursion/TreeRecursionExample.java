package com.softgroup.dsa.recursion;

public class TreeRecursionExample {
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2); // Tree recursion: two recursive calls
		}
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
	}
}
