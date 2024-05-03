package com.softgroup.dsa.string;

public class ArrayRotation {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayRotation rotation = new ArrayRotation();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotation.rotate(nums, k);
        System.out.println("Rotated Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
