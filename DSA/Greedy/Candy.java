package com.softgroup.dsa.greedy;

import java.util.Arrays;

public class Candy {
	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);

		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}

		int total = 0;
		for (int candy : candies) {
			total += candy;
		}

		return total;
	}

	public static void main(String[] args) {
		int[] ratings = { 1, 0, 2 };
		System.out.println("Minimum number of candies required: " + candy(ratings));
	}
}
