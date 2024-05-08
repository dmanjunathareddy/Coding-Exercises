package com.softgroup.dsa.binarysearch;

public class BinarySearchProblem3 {
    public static int findFirstGreaterOrEqual(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 8;
        int index = findFirstGreaterOrEqual(arr, target);
        if (index != -1)
            System.out.println("Index of the first element greater than or equal to " + target + " is: " + index);
        else
            System.out.println("No such element found.");
    }
}
