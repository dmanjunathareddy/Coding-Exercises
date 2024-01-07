package com.softgroup.dsa.leetcode75;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		ArrayList<Integer> prices = new ArrayList<>();
		prices.add(7);
		prices.add(1);
		prices.add(5);
		prices.add(3);
		prices.add(6);
		prices.add(4);
		System.out.println(maximumProfit(prices));
	}

	public static int maximumProfit(ArrayList<Integer> prices) {
		int profit = 0;
		int mini = prices.get(0);
		for (int i = 1; i < prices.size(); i++) {
			int curProfit = prices.get(i) - mini;
			profit = Math.max(profit, curProfit);
			mini = Math.min(mini, prices.get(i));
		}
		return profit;
	}
}