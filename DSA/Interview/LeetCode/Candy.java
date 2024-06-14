package com.softgroup.dsa.interview.leetcode;
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }

        // Step 1: Create an array to store the minimum candies needed for each child
        int[] candies = new int[n];
        // Step 2: Initialize each child with one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Step 3: Traverse from left to right, ensuring right neighbor condition
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 4: Traverse from right to left, ensuring left neighbor condition
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 5: Sum up all the candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Candy solution = new Candy();
        int[] ratings = {1, 0, 2};
        System.out.println(solution.candy(ratings)); // Output: 5
    }
}
