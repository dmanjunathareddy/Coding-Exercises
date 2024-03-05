package com.softgroup.dsa.arrays;

import java.util.PriorityQueue;

public class KthElementUsingMaxHeap {
	static void kthLargestMaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int f = k - 1;
		while (f > 0) {
			pq.remove();
			f--;
		}
		System.out.println("Kth Largest element: " + pq.peek());
	}

	static void kthSmallestMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int f = k - 1;
		while (f > 0) {
			pq.remove();
			f--;
		}
		System.out.println("Kth Smallest element: " + pq.peek());
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 6, 4, 5, 3 };
		kthLargestMaxHeap(arr, 3);
		kthSmallestMinHeap(arr, 3);
	}
}
