package com.softgroup.dsa.heap;

import java.util.*;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		List<Integer> result = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().getKey());
		}

		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
		List<Integer> result = topKFrequentElements.topKFrequent(nums, k);
		System.out.println("The top " + k + " frequent elements are: " + result);
	}
}
