package com.softgroup.dsa.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestSalary {
	public static void main(String[] args) {
		List<Integer> salaries = Arrays.asList(1000, 2000, 3000, 4000, 5000);

		Optional<Integer> secondHighestSalary = salaries.stream().distinct() // Remove duplicates
				.sorted(Comparator.reverseOrder()) 
				.skip(1)
				.findFirst();

		if (secondHighestSalary.isPresent()) {
			System.out.println("Second highest salary: " + secondHighestSalary.get());
		} else {
			System.out.println("No second highest salary found.");
		}
	}
}
