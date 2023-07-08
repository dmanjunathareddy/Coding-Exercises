package com.softgroup.patterns;

public class NumberRightTrianglePattern {
/*
	1 
	1 2 
	1 2 3 
	1 2 3 4 
	1 2 3 4 5 
**/

	public static void main(String[] args) {
		printNumberRightTriangle(5);
	}

	static void printNumberRightTriangle(int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
