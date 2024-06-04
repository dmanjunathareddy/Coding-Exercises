package com.softgroup.dsa.interview;

import java.util.Arrays;

public class HouseRobberII {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        robLinear(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private static int robLinear(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println("Maximum amount of money you can rob: " + rob(nums)); // Output: 3
    }
}
