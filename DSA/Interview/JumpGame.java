package com.softgroup.dsa.interview;
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return lastGoodIndex == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can reach the last index: " + canJump(nums)); // Output: true
    }
}
