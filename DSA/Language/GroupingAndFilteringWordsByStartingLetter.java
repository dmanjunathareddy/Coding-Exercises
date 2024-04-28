package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndFilteringWordsByStartingLetter {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "pear");

		// Group words by starting letter and filter groups with more than 1 word
		Map<Character, List<String>> wordsByStartingLetter = words.stream()
				.collect(Collectors.groupingBy(word -> word.charAt(0)));

		// Filter groups with more than 1 word
		wordsByStartingLetter = wordsByStartingLetter.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Print the groups
		wordsByStartingLetter.forEach((startingLetter, group) -> {
			System.out.println("Words starting with '" + startingLetter + "': " + group);
		});
	}
}
