package com.softgroup.dsa.queue;

import java.util.Stack;

public class QueueUsingStacks<T> {
	private Stack<T> stack1; // For enqueue operation
	private Stack<T> stack2; // For dequeue operation

	/** Initialize your data structure here. */
	public QueueUsingStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void enqueue(T x) {
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public T dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.isEmpty() ? null : stack2.pop();
	}

	/** Get the front element. */
	public T peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.isEmpty() ? null : stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public static void main(String[] args) {
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue()); // Output: 1
		System.out.println(queue.dequeue()); // Output: 2
		queue.enqueue(4);
		System.out.println(queue.dequeue()); // Output: 3
		System.out.println(queue.dequeue()); // Output: 4
		System.out.println(queue.isEmpty()); // Output: true
	}
}
