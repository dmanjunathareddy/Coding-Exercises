package com.softgroup.dsa.string;

import java.util.*;

public class AnagramGroups {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);
			if (!anagramMap.containsKey(sortedStr)) {
				anagramMap.put(sortedStr, new ArrayList<>());
			}
			anagramMap.get(sortedStr).add(str);
		}
		return new ArrayList<>(anagramMap.values());
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(strs);
		System.out.println("Anagram groups: " + result);
	}
}
