package com.softgroup.dsa.slidingwindow;

public class SlidingWindowProblem1 {
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[i - (k - 1)];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSumSubarray(arr, k));
    }
}
