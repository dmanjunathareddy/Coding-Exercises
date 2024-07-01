package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] medians = medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(medians));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new double[0];
        }

        int n = nums.length;
        double[] result = new double[n - k + 1];
        MedianHeap medianHeap = new MedianHeap();

        for (int i = 0; i < n; i++) {
            medianHeap.add(nums[i]);
            if (i >= k) {
                medianHeap.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = medianHeap.getMedian();
            }
        }

        return result;
    }

    static class MedianHeap {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianHeap() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void add(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            balanceHeaps();
        }

        public void remove(int num) {
            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }
            balanceHeaps();
        }

        private void balanceHeaps() {
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double getMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
