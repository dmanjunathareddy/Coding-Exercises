package com.softgroup.dsa.prefixSumTechnique;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println("Length of the shortest subarray with sum at least " + k + ": " + shortestSubarray(nums, k));
    }
}
