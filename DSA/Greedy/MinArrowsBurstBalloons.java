package com.softgroup.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsBurstBalloons {
	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;

		Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

		int arrows = 1;
		int end = points[0][1];

		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > end) {
				arrows++;
				end = points[i][1];
			}
		}

		return arrows;
	}

	public static void main(String[] args) {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println("Minimum number of arrows to burst all balloons: " + findMinArrowShots(points));
	}
}
