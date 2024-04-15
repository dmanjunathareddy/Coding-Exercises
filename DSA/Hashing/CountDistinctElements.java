package com.softgroup.dsa.hash;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {

	public static int countDistinctElements(int[] arr) {
		// Create a HashSet to store unique elements
		Set<Integer> uniqueElements = new HashSet<>();

		// Iterate through the array and add each element to the set
		for (int num : arr) {
			uniqueElements.add(num);
		}

		// The size of the set is the count of distinct elements
		return uniqueElements.size();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5 };

		int result = countDistinctElements(arr);

		System.out.println("The number of distinct elements is: " + result);
	}
}
