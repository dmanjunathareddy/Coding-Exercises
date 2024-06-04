package com.softgroup.dsa.interview;
public class MaxSubarraySumWithOneDeletion {
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] forward = new int[n];
        int[] backward = new int[n];

        forward[0] = arr[0];
        for (int i = 1; i < n; i++) {
            forward[i] = Math.max(arr[i], forward[i - 1] + arr[i]);
        }

        backward[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = Math.max(arr[i], backward[i + 1] + arr[i]);
        }

        int maxSum = forward[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, forward[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, forward[i - 1] + backward[i + 1]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println("Maximum sum with one deletion: " + maximumSum(arr)); // Output: 4
    }
}
