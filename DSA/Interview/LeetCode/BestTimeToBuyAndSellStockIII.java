package com.softgroup.dsa.interview.leetcode;
public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        // Arrays to store the maximum profit up to day i and from day i onwards
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Calculate the maximum profit for one transaction from day 0 to day i
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        // Calculate the maximum profit for one transaction from day i to the last day
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        // Calculate the maximum profit by summing the left and right profits
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices)); // Output: 6
    }
}
