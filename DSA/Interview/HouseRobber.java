package com.softgroup.dsa.interview;
public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println("Maximum amount robbed: " + rob(nums)); // Output: 3
    }
}
