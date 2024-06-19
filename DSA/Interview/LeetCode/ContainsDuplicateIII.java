package com.softgroup.dsa.interview.leetcode;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];

            // Check if there is any number in the range [num - t, num + t]
            Long floor = set.floor(num + t);
            Long ceiling = set.ceiling(num - t);
            if ((floor != null && floor >= num) || (ceiling != null && ceiling <= num)) {
                return true;
            }

            set.add(num);

            // Ensure the set only contains the last k elements
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
