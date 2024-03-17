package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");

		List<String> result = fruits.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
	}

}
