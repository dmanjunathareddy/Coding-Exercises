package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class CountOfRangeSum {
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;

        TreeSet<Long> set = new TreeSet<>();
        long sum = 0;
        set.add(0L);
        for (int num : nums) {
            sum += num;
            set.add(sum);
        }

        List<Long> sortedPrefixSums = new ArrayList<>(set);
        SegmentTree segmentTree = new SegmentTree(sortedPrefixSums);
        int count = 0;
        sum = 0;

        for (int num : nums) {
            sum += num;
            long left = sum - upper;
            long right = sum - lower;
            count += segmentTree.countRange(left, right);
            segmentTree.update(sum);
        }

        return count;
    }

    class SegmentTree {
        private List<Long> sortedPrefixSums;
        private int[] tree;

        public SegmentTree(List<Long> sortedPrefixSums) {
            this.sortedPrefixSums = sortedPrefixSums;
            int size = sortedPrefixSums.size();
            this.tree = new int[2 * size];
        }

        public void update(long val) {
            int idx = Collections.binarySearch(sortedPrefixSums, val) + sortedPrefixSums.size();
            while (idx > 0) {
                tree[idx]++;
                idx /= 2;
            }
        }

        public int countRange(long left, long right) {
            int l = Collections.binarySearch(sortedPrefixSums, left);
            int r = Collections.binarySearch(sortedPrefixSums, right);
            if (l < 0) l = -l - 1;
            if (r < 0) r = -r - 1;
            else r++;
            int res = 0;
            l += sortedPrefixSums.size();
            r += sortedPrefixSums.size();
            while (l < r) {
                if ((l & 1) == 1) res += tree[l++];
                if ((r & 1) == 1) res += tree[--r];
                l /= 2;
                r /= 2;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        CountOfRangeSum solution = new CountOfRangeSum();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        System.out.println(solution.countRangeSum(nums, lower, upper)); // Output: 3
    }
}
