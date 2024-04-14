package com.softgroup.dsa.greedy;

import java.util.Arrays;

public class MinimumPlatforms {

	public static int findMinimumPlatforms(int[] arrival, int[] departure) {
		// Sort the arrival and departure arrays
		Arrays.sort(arrival);
		Arrays.sort(departure);

		int n = arrival.length;
		int platformsNeeded = 0;
		int maxPlatforms = 0;

		int i = 0; // Pointer for arrival array
		int j = 0; // Pointer for departure array

		while (i < n && j < n) {
			if (arrival[i] <= departure[j]) {
				// A train is arriving, increase platform count
				platformsNeeded++;
				i++;

				// Update the maximum platforms needed
				maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
			} else {
				// A train is departing, decrease platform count
				platformsNeeded--;
				j++;
			}
		}

		return maxPlatforms;
	}

	public static void main(String[] args) {
		int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
		int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

		int minPlatforms = findMinimumPlatforms(arrival, departure);
		System.out.println("Minimum number of platforms required: " + minPlatforms);
	}
}
