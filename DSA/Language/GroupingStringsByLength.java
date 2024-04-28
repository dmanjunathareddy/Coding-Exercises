package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingStringsByLength {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "pear");

		// Group words by length
		Map<Integer, List<String>> wordsByLength = words.stream().collect(Collectors.groupingBy(String::length));

		// Print the groups
		wordsByLength.forEach((length, group) -> {
			System.out.println("Words with length " + length + ": " + group);
		});
	}
}
