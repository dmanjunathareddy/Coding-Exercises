package com.softgroup.dsa.array;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class WordCount {
	public static void main(String[] args) {
		String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		Map<String, Integer> wordCount = new HashMap<>();
		String[] words = paragraph.split("\\s+");
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		int maxCount = 0;
		int secondMaxCount = 0;
		for (int count : wordCount.values()) {
			if (count > maxCount) {
				secondMaxCount = maxCount;
				maxCount = count;
			} else if (count > secondMaxCount && count != maxCount) {
				secondMaxCount = count;
			}
		}
		List<String> secondHighestWords = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			if (entry.getValue() == secondMaxCount) {
				secondHighestWords.add(entry.getKey());
			}
		}
		System.out.println("Second-highest occurrence count: " + secondMaxCount);
		System.out.println("Word(s) with the second-highest occurrence count: " + secondHighestWords);
	}
}
