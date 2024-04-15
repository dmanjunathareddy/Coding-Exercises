package com.softgroup.dsa.hash;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumZero {

    public static boolean hasSubarrayWithZeroSum(int[] arr) {
        // Create a HashSet to store the cumulative sums
        Set<Integer> sumSet = new HashSet<>();
        
        // Initialize the cumulative sum to zero
        int cumulativeSum = 0;

        // Iterate through the array
        for (int num : arr) {
            // Add the current number to the cumulative sum
            cumulativeSum += num;
            
            // Check if the cumulative sum is zero or if it already exists in the set
            if (cumulativeSum == 0 || sumSet.contains(cumulativeSum)) {
                return true; // Found a subarray with zero sum
            }
            
            // Add the cumulative sum to the set
            sumSet.add(cumulativeSum);
        }
        
        // If we reach here, it means no subarray with sum zero was found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, 5};

        boolean result = hasSubarrayWithZeroSum(arr);

        if (result) {
            System.out.println("There is a subarray with sum zero.");
        } else {
            System.out.println("There is no subarray with sum zero.");
        }
    }
}
