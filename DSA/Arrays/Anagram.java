package com.softgroup.dsa.array;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "lister";
		String s2 = "Silent";
		if (areAnagram(s1, s2)) {
			System.out.println(s1 + " and " + s2 + "are anagram");
		} else {
			System.out.println(s1 + " and " + s2 + "are not anagram");
		}
	}
	private static boolean areAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return Arrays.equals(ch1, ch2);
	}
}
