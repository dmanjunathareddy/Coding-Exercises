package com.softgroup.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class SumOfDoubledEvenNumbers {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * 2).sum();
		System.out.println(sum);

	}
}
