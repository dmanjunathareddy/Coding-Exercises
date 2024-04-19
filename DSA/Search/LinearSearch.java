package com.softgroup.dsa.search;

public class LinearSearch {

    // Function to perform linear search
    public static int linearSearch(int[] arr, int target) {
        // Iterate through each element of the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element matches the target
            if (arr[i] == target) {
                // Return the index where the target is found
                return i;
            }
        }
        // If the target is not found in the array, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {4, 2, 7, 1, 9, 3, 5, 6};
        // Target element to search for
        int target = 9;

        // Perform linear search
        int index = linearSearch(arr, target);

        // Output the result
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }
}
