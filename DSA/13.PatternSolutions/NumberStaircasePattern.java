package com.softgroup.patterns;

public class NumberStaircasePattern {
/*
	1 
	2 2 
	3 3 3 
	4 4 4 4 
	5 5 5 5 5 
**/

	public static void main(String[] args) {
		printStaircasePattern(5);
	}

	static void printStaircasePattern(int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
