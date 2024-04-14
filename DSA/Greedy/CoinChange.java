package com.softgroup.dsa.greedy;

import java.util.*;

public class CoinChange {

	public static int minCoins(int[] coins, int amount) {
		// Sort the coins array in descending order
		Arrays.sort(coins);
		int n = coins.length;
		int minCoins = 0;

		for (int i = n - 1; i >= 0; i--) {
			// Calculate how many coins of the current denomination can be used
			int count = amount / coins[i];
			// Reduce the amount by the total value of coins used
			amount -= count * coins[i];
			// Increase the coin count
			minCoins += count;

			// If the amount is zero, break out of the loop
			if (amount == 0) {
				break;
			}
		}

		return amount == 0 ? minCoins : -1; // Return -1 if it's not possible to make the amount with the given coins
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100 };
		int amount = 93;

		int result = minCoins(coins, amount);
		if (result != -1) {
			System.out.println("Minimum number of coins required: " + result);
		} else {
			System.out.println("It's not possible to make the amount with the given coins.");
		}
	}
}
