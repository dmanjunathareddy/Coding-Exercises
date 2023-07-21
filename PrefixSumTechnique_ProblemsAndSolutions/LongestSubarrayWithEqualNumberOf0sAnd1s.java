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
}
