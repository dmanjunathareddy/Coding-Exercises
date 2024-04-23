package com.softgroup.dsa.greedy;

import java.util.Arrays;

public class TaskScheduler {
	public static int leastInterval(char[] tasks, int n) {
		int[] frequency = new int[26];
		for (char task : tasks) {
			frequency[task - 'A']++;
		}

		Arrays.sort(frequency);

		int maxFrequency = frequency[25] - 1;
		int idleSlots = maxFrequency * n;

		for (int i = 24; i >= 0 && frequency[i] > 0; i--) {
			idleSlots -= Math.min(frequency[i], maxFrequency);
		}

		return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
	}

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println("Least number of units of time: " + leastInterval(tasks, n));
	}
}
