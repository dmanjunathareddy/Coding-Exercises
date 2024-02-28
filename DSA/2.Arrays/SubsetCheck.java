package com.softgroup.dsa.arrays;

import java.util.Arrays;

public class SubsetCheck {
	public static String isSubset(long a1[], long a2[], long n, long m) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (a1[i] == a2[j]) {
				i++;
				j++;
			} else if (a1[i] < a2[j]) {
				i++;
			} else {
				return "No";
			}
		}
		if (j == m) {
			return "Yes";
		} else {
			return "No";
		}
	}

	public static void main(String[] args) {
		long[] a1 = { 1, 2, 3, 4, 5 };
		long[] a2 = { 3, 5 };
		long n = a1.length;
		long m = a2.length;

		System.out.println(isSubset(a1, a2, n, m));
	}
}
//https://www.geeksforgeeks.org/problems/array-subset-of-another-array2317/1