package com.softgroup.dsa.interview.leetcode;
import java.util.Arrays;

public class KthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestPairDistance solver = new KthSmallestPairDistance();
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(solver.smallestDistancePair(nums, k)); // Output: 0
    }
}
