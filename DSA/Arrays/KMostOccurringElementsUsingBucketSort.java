package com.softgroup.dsa.array;

import java.util.*;

public class KMostOccurringElementsUsingBucketSort {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		// Create a frequency map
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Create buckets to store elements with the same frequency
		List<Integer>[] buckets = new List[nums.length + 1];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}

		// Add elements to corresponding buckets based on their frequency
		for (int num : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(num);
			buckets[frequency].add(num);
		}

		// Traverse the buckets from higher frequency to lower frequency to get the K
		// most occurring elements
		List<Integer> result = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
			if (buckets[i].size() > 0) {
				result.addAll(buckets[i]);
			}
		}

		return result.subList(0, k);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		List<Integer> topKFrequentElements = topKFrequent(nums, k);
		System.out.println("Top " + k + " most occurring elements: " + topKFrequentElements);
	}
}
