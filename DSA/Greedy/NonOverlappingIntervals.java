package com.softgroup.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

		int end = intervals[0][1];
		int count = 1; // count of non-overlapping intervals

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= end) {
				count++;
				end = intervals[i][1];
			}
		}

		return intervals.length - count;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println("Minimum number of intervals to remove: " + eraseOverlapIntervals(intervals));
	}
}
