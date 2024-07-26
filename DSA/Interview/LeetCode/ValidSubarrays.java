package com.softgroup.dsa.interview.leetcode;
public class ValidSubarrays {
    public int validSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[i] <= nums[stack[top]]) {
                top--;
            }
            count += (top == -1) ? n - i : stack[top] - i;
            stack[++top] = i;
        }

        return count;
    }

    public static void main(String[] args) {
        ValidSubarrays solution = new ValidSubarrays();
        int[] nums = {1, 4, 2, 5, 3};
        System.out.println(solution.validSubarrays(nums)); // Output: 11
    }
}


