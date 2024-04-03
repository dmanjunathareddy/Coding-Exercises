package com.softgroup.dsa.slidingwindowtechnique;

public class SmallestSubarrayWithGivenSum {

    public static int smallestSubarrayLength(int[] nums, int targetSum) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (currentSum >= targetSum) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= nums[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        int targetSum = 8;
        System.out.println("Smallest subarray length with sum " + targetSum + ": " + smallestSubarrayLength(nums, targetSum));
    }
}
