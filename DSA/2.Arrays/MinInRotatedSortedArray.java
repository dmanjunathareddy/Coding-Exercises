package com.softgroup.dsa.arrays;

public class MinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                // The right half is sorted, so minimum must be in the left half
                high = mid;
            } else {
                // The left half is sorted, so minimum must be in the right half
                low = mid + 1;
            }
        }
        // At this point, low and high converge to the minimum element
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = findMin(nums);
        System.out.println("Minimum element in the rotated sorted array: " + min);
    }
}
