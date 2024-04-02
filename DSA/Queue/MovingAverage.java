package com.softgroup.dsa.queue;

public class MovingAverage {
	private int[] window;
	private int size;
	private int head;
	private double sum;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.window = new int[size];
		this.size = size;
		this.head = 0;
		this.sum = 0.0;
	}

	public double next(int val) {
		// Calculate the index where the new value will be inserted
		int tail = (head + 1) % size;

		// Update sum by subtracting the oldest value and adding the new value
		sum = sum - window[tail] + val;

		// Update circular buffer with new value
		window[tail] = val;

		// Move head pointer to the next position
		head = tail;

		// Calculate and return the moving average
		return sum / Math.min(size, head + 1);
	}

	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1)); // Output: 1.0
		System.out.println(obj.next(10)); // Output: 5.5
		System.out.println(obj.next(3)); // Output: 4.666666666666667
		System.out.println(obj.next(5)); // Output: 6.0
	}
}
