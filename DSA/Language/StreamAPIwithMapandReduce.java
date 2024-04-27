package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;

public class StreamAPIwithMapandReduce {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Multiply each number by 2 and then calculate sum using Stream API
		int sum = numbers.stream().mapToInt(n -> n * 2).sum();
		System.out.println("Sum after doubling each number: " + sum);
	}
}
