package com.softgroup.patterns;

import java.util.HashMap;

public class LongestSubarrayWithEqualNumberOf0sAnd1s {
	int maxLength = 0;

	int maxLen(int[] arr, int N) {
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		countMap.put(0, -1);
		int count = 0;
		for (int i = 0; i < N; i++) {
			count += (arr[i] == 1) ? 1 : -1;
			if (countMap.containsKey(count)) {
				int prevIndex = countMap.get(count);
				maxLength = Math.max(maxLength, i - prevIndex);
			} else {
				countMap.put(count, i);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0 };
		int N = arr.length;

		LongestSubarrayWithEqualNumberOf0sAnd1s solution = new LongestSubarrayWithEqualNumberOf0sAnd1s();
		int result = solution.maxLen(arr, N);
		System.out.println("Longest sub array length: " + result);
	}
}
