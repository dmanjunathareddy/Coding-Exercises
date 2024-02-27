package com.softgroup.dsa.dp;

import java.util.Arrays;

public class MinimumCoins {

	public static int minCoins(int[] coins, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= target; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int target = 11;
		int minCoinsRequired = minCoins(coins, target);
		if (minCoinsRequired == -1) {
			System.out.println("It is not possible to make the target sum with the given coins.");
		} else {
			System.out.println("Minimum number of coins required: " + minCoinsRequired);
		}
	}
}
