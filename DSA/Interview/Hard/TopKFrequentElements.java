package com.softgroup.dsa.interview;
import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of the top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract the elements from the min-heap
        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = minHeap.poll().getKey();
        }

        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }
}
