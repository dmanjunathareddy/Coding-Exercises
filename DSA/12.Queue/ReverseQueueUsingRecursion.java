package com.softgroup.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {
	public static void reverseQueue(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return;
		}
		int front = queue.poll();
		reverseQueue(queue);
		queue.add(front);
	}

	public static void printQueue(Queue<Integer> queue) {
		for (Integer element : queue) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= 5; i++) {
			queue.add(i);
		}

		System.out.println("Original Queue:");
		printQueue(queue);
		reverseQueue(queue);

		System.out.println("Reversed Queue:");
		printQueue(queue);
	}
}
