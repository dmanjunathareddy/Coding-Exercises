package com.softgroup.dsa.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		int wordLength = words[0].length();
		int wordsCount = words.length;
		int totalLength = wordLength * wordsCount;

		Map<String, Integer> wordFrequency = new HashMap<>();
		for (String word : words) {
			wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
		}

		for (int i = 0; i <= s.length() - totalLength; i++) {
			Map<String, Integer> wordsSeen = new HashMap<>();
			int j = 0;
			while (j < wordsCount) {
				String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
				if (wordFrequency.containsKey(word)) {
					wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
					if (wordsSeen.get(word) > wordFrequency.getOrDefault(word, 0))
						break;
				} else {
					break;
				}
				j++;
			}
			if (j == wordsCount) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> result = findSubstring(s, words);
		System.out.println("Indices of substrings with concatenation of all words: " + result);
	}
}
