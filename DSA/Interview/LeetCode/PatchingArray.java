package com.softgroup.dsa.interview.leetcode;
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0, i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }

    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        int[] nums = {1, 3};
        int n = 6;

        System.out.println(pa.minPatches(nums, n)); // Output: 1

        nums = new int[]{1, 5, 10};
        n = 20;

        System.out.println(pa.minPatches(nums, n)); // Output: 2

        nums = new int[]{1, 2, 2};
        n = 5;

        System.out.println(pa.minPatches(nums, n)); // Output: 0
    }
}
