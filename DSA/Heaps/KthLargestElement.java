package com.softgroup.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		KthLargestElement kthLargest = new KthLargestElement();
		int result = kthLargest.findKthLargest(nums, k);
		System.out.println("The " + k + "th largest element is: " + result);
	}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max heap
		for (int num : nums) {
			maxHeap.offer(num);
		}
		while (k > 1) {
			maxHeap.poll();
			k--;
		}
		return maxHeap.poll();
	}
}
