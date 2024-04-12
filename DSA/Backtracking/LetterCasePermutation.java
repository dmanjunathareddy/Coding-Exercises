package com.softgroup.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
		List<String> results = new ArrayList<>();
		backtrack(results, s.toCharArray(), 0);
		return results;
	}

	private void backtrack(List<String> results, char[] charArray, int index) {
		if (index == charArray.length) {
			results.add(new String(charArray));
			return;
		}

		// Add current case
		backtrack(results, charArray, index + 1);

		// Change case and recurse
		if (Character.isLetter(charArray[index])) {
			charArray[index] = Character.isLowerCase(charArray[index]) ? Character.toUpperCase(charArray[index])
					: Character.toLowerCase(charArray[index]);

			backtrack(results, charArray, index + 1);

			// Revert change
			charArray[index] = Character.isLowerCase(charArray[index]) ? Character.toUpperCase(charArray[index])
					: Character.toLowerCase(charArray[index]);
		}
	}

	public static void main(String[] args) {
		LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
		String s = "a1b2";
		List<String> results = letterCasePermutation.letterCasePermutation(s);
		for (String str : results) {
			System.out.println(str);
		}
	}
}
