package com.softgroup.dsa.interview.leetcode;
public class FindMinInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right part
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum must be in the left part or at mid
                right = mid;
            } else {
                // nums[mid] == nums[right], we cannot determine which part, reduce right by 1
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArrayII solver = new FindMinInRotatedSortedArrayII();
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println("The minimum is: " + solver.findMin(nums));  // Output should be 0
    }
}
