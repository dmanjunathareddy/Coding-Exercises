package com.softgroup.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateCharatersWithExtrSpace {
	public static void main(String[] args) {
		String input = "ManjunathaReddy";
		List<Character> findDuplicateCharaters = findDuplicateCharaters(input);
		for (Character character : findDuplicateCharaters) {
			System.out.print(character);
		}
	}

	private static List<Character> findDuplicateCharaters(String input) {
		List<Character> result = new ArrayList<>();
		List<Character> dupicateChars = new ArrayList<>();
		char[] chars = input.toCharArray();

		for (char c : chars) {
			if (dupicateChars.contains(c)) {
				if (!result.contains(c)) {
					result.add(c);
				}
			} else {
				dupicateChars.add(c);
			}
		}
		return result;

	}

}
