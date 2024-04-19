package com.softgroup.dsa.search;

public class SearchRotatedSortedArray {

    // Function to search for an element in a rotated sorted array
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Perform a modified binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1; // Search in left half
                } else {
                    left = mid + 1; // Search in right half
                }
            } else {
                // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1; // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }
        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int target = 3;

        int index = search(arr, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }
}
