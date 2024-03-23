package com.softgroup.dsa.array;

import java.util.Arrays;

public class MinimumPlatforms {
	public static int findMinimumPlatforms(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);

		int platformsNeeded = 1;
		int result = 1;
		int i = 1, j = 0;

		while (i < arrival.length && j < departure.length) {
			if (arrival[i] <= departure[j]) {
				platformsNeeded++;
				i++;
				result = Math.max(result, platformsNeeded);
			} else {
				platformsNeeded--;
				j++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
		int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

		int minPlatforms = findMinimumPlatforms(arrival, departure);
		System.out.println("Minimum platforms needed: " + minPlatforms);
	}
}
