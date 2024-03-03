package com.softgroup.dsa.string;

public class CountAndSay {
	public static void main(String[] args) {
		int n = 5;
		String result = countAndSay(n);
		System.out.println("Term " + n + " of the Count and Say sequence is: " + result);
	}

	public static String countAndSay(int n) {
		if (n <= 0)
			return "";
		String result = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			char prevChar = result.charAt(0);
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				char currentChar = result.charAt(j);
				if (currentChar == prevChar) {
					count++;
				} else {
					sb.append(count).append(prevChar);
					count = 1;
					prevChar = currentChar;
				}
			}
			sb.append(count).append(prevChar);
			result = sb.toString();
		}
		return result;
	}
}
