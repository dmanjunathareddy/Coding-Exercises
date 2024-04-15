package com.softgroup.dsa.hash;

import java.util.*;

public class MostFrequentElement {

	public static int findMostFrequentElement(int[] nums) {
		// Create a frequency map
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Find the element with the highest frequency
		int mostFrequentElement = nums[0]; // Initialize with the first element
		int maxFrequency = 0;
		for (int num : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(num);
			if (frequency > maxFrequency) {
				mostFrequentElement = num;
				maxFrequency = frequency;
			}
		}

		return mostFrequentElement;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };
		int mostFrequent = findMostFrequentElement(nums);
		System.out.println("Most frequent element: " + mostFrequent);
	}
}
