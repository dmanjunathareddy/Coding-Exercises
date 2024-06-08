package com.softgroup.dsa.stack;

import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // If stack is empty, there is no greater element to the right
            // Otherwise, the top element of the stack is the next greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        int[] nextGreater = nextGreaterElement(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreater));
    }
}
