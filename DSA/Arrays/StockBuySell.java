package com.softgroup.dsa.array;
public class StockBuySell {

    // Method to find the maximum profit
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            throw new IllegalArgumentException("At least two prices are required to calculate profit.");
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the profit if the stock was bought at minPrice and sold at current price
            int profit = price - minPrice;
            // Update the maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    // Main method to test the maxProfit method
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        try {
            int profit = maxProfit(prices);
            System.out.println("Maximum profit: " + profit);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
