package com.softgroup.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		return backtrack(s, wordDict, 0);
	}

	private boolean backtrack(String s, List<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}

		for (String word : wordDict) {
			int wordLen = word.length();
			if (start + wordLen <= s.length() && s.substring(start, start + wordLen).equals(word)) {
				if (backtrack(s, wordDict, start + wordLen)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("apple");
		wordDict.add("pen");
		String s = "applepenapple";
		System.out.println(wordBreak.wordBreak(s, wordDict)); // Output: true
	}
}
