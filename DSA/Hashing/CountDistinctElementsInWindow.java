package com.softgroup.dsa.hash;

import java.util.*;

public class CountDistinctElementsInWindow {

    public static List<Integer> countDistinct(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int distinctCount = 0;

        // Count distinct elements in the first window
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1) // New distinct element found
                distinctCount++;
        }
        result.add(distinctCount);

        // Slide the window and count distinct elements in each window
        for (int i = k; i < nums.length; i++) {
            // Remove the leftmost element from the window
            map.put(nums[i - k], map.get(nums[i - k]) - 1);
            if (map.get(nums[i - k]) == 0) // No occurrence of leftmost element
                distinctCount--;

            // Add the new element to the window
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1) // New distinct element found
                distinctCount++;

            result.add(distinctCount);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        List<Integer> distinctCounts = countDistinct(nums, k);
        System.out.println("Distinct elements count in every window of size " + k + ": " + distinctCounts);
    }
}
