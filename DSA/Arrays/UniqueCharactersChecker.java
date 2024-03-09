package com.softgroup.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharactersChecker {
	public static boolean hasUniqueCharacters(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}

		Set<Character> characterSet = new HashSet<>();

		for (char c : str.toCharArray()) {
			if (characterSet.contains(c)) {
				return false;
			}
			characterSet.add(c);
		}

		return true; // All characters are unique
	}

	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "hello";

		System.out.println("String \"" + str1 + "\" has unique characters? " + hasUniqueCharacters(str1)); // Output:
																											// true
		System.out.println("String \"" + str2 + "\" has unique characters? " + hasUniqueCharacters(str2)); // Output:
																											// false
	}
}
