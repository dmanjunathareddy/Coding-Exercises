package com.softgroup.patterns;

public class ReverseTriangleStarPattern {
/*
	* * * * * * 
	* * * * * 
	* * * * 
	* * * 
	* * 
	* 
**/
	public static void main(String[] args) {
		printReverseTriangleStar(5);
	}

	static void printReverseTriangleStar(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n-i+1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
