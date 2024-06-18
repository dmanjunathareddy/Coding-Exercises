package com.softgroup.dsa.interview.leetcode;
public class MaximumSumIncreasingSubsequence {

    // Method to find the maximum sum increasing subsequence
    public static int maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];

        // Initialize msis values for all indexes
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }

        // Compute maximum sum values in bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        // Find the maximum value in msis array
        int max = msis[0];
        for (int i = 1; i < n; i++) {
            if (msis[i] > max) {
                max = msis[i];
            }
        }

        return max;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum Sum Increasing Subsequence is " + maxSumIncreasingSubsequence(arr));
    }
}
