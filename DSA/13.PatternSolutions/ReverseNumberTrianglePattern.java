package com.softgroup.patterns;

public class ReverseNumberTrianglePattern {
/*
	1 2 3 4 5 
	1 2 3 4 
	1 2 3 
	1 2 
	1 
**/
	public static void main(String[] args) {
		printReverseNumberTriangle(5);
	}

	static void printReverseNumberTriangle(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j < n-i+1; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
