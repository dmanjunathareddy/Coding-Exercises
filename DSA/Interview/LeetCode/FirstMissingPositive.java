package com.softgroup.dsa.interview.leetcode;
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] and nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("The first missing positive number is: " + firstMissingPositive(nums)); // Output: 2

        int[] nums2 = {1, 2, 0};
        System.out.println("The first missing positive number is: " + firstMissingPositive(nums2)); // Output: 3

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("The first missing positive number is: " + firstMissingPositive(nums3)); // Output: 1
    }
}
