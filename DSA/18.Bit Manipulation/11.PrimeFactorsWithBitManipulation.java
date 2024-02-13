package com.softgroup.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsWithBitManipulation {

	public static void main(String[] args) {
		int num = 60;
		List<Integer> factors = primeFactors(num);
		System.out.println("Prime factors of " + num + " are: ");
		for (int factor : factors) {
			System.out.print(factor + " ");
		}
	}

	public static List<Integer> primeFactors(int num) {
		List<Integer> factors = new ArrayList<>();

		// Handle 2 separately as it's the only even prime number
		while (num % 2 == 0) {
			factors.add(2);
			num >>= 1; // Equivalent to num = num / 2
		}

		// Now num must be odd
		// Start from 3 and increment by 2 (to skip even numbers)
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			while (num % i == 0) {
				factors.add(i);
				num /= i;
			}
		}

		// If num is still greater than 2, it must be a prime number
		if (num > 2) {
			factors.add(num);
		}

		return factors;
	}
}
