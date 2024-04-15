package com.softgroup.dsa.hash;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {

	public static int findFirstRepeatingElement(int[] arr) {
		// Create a HashSet to track elements we've seen
		Set<Integer> seenElements = new HashSet<>();

		// Iterate through the array
		for (int num : arr) {
			// If the current element is already in the set, it's the first repeating
			// element
			if (seenElements.contains(num)) {
				return num;
			}
			// Add the current element to the set
			seenElements.add(num);
		}

		// If we reach here, it means there is no repeating element
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 5 };

		int result = findFirstRepeatingElement(arr);

		if (result != -1) {
			System.out.println("The first repeating element is: " + result);
		} else {
			System.out.println("There is no repeating element.");
		}
	}
}
