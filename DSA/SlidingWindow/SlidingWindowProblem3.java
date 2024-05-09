package com.softgroup.dsa.slidingwindowtechnique;

public class SlidingWindowProblem3 {
    public static int smallestSubarrayLength(int[] arr, int target) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int target = 7;
        System.out.println("Smallest subarray length with sum greater than or equal to " + target + " is: " + smallestSubarrayLength(arr, target));
    }
}
