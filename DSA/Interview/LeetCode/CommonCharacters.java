package com.softgroup.dsa.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {
	public static List<Character> commonChars(String[] words) {
		List<Character> result = new ArrayList<>();

		if (words == null || words.length == 0) {
			return result;
		}

		int[] minFreq = new int[26];
		for (char c : words[0].toCharArray()) {
			minFreq[c - 'a']++;
		}

		for (int i = 1; i < words.length; i++) {
			int[] charFreq = new int[26];
			for (char c : words[i].toCharArray()) {
				charFreq[c - 'a']++;
			}
			for (int j = 0; j < 26; j++) {
				minFreq[j] = Math.min(minFreq[j], charFreq[j]);
			}
		}

		for (int i = 0; i < 26; i++) {
			while (minFreq[i] > 0) {
				result.add((char) (i + 'a'));
				minFreq[i]--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] words = { "bella", "label", "roller" };
		List<Character> commonCharacters = commonChars(words);
		System.out.println("Common characters: " + commonCharacters);
	}
}
