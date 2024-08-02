package com.softgroup.dsa.interview.leetcode.top150;
import java.util.HashMap;
import java.util.Map;

public class OnlineMajorityElement {
    static class SegmentTree {
        private int[] arr;
        private int n;
        private Map<Integer, Integer>[] segTree;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.segTree = new HashMap[4 * n];
            buildTree(0, 0, n - 1);
        }

        private void buildTree(int node, int start, int end) {
            if (start == end) {
                segTree[node] = new HashMap<>();
                segTree[node].put(arr[start], 1);
            } else {
                int mid = (start + end) / 2;
                buildTree(2 * node + 1, start, mid);
                buildTree(2 * node + 2, mid + 1, end);
                segTree[node] = merge(segTree[2 * node + 1], segTree[2 * node + 2]);
            }
        }

        private Map<Integer, Integer> merge(Map<Integer, Integer> left, Map<Integer, Integer> right) {
            Map<Integer, Integer> merged = new HashMap<>(left);
            for (Map.Entry<Integer, Integer> entry : right.entrySet()) {
                merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
            return merged;
        }

        public Map<Integer, Integer> query(int l, int r) {
            return queryUtil(0, 0, n - 1, l, r);
        }

        private Map<Integer, Integer> queryUtil(int node, int start, int end, int l, int r) {
            if (r < start || l > end) {
                return new HashMap<>();
            }
            if (l <= start && r >= end) {
                return segTree[node];
            }
            int mid = (start + end) / 2;
            Map<Integer, Integer> leftQuery = queryUtil(2 * node + 1, start, mid, l, r);
            Map<Integer, Integer> rightQuery = queryUtil(2 * node + 2, mid + 1, end, l, r);
            return merge(leftQuery, rightQuery);
        }
    }

    public static Integer majorityElementInRange(int[] arr, int l, int r) {
        SegmentTree segmentTree = new SegmentTree(arr);
        Map<Integer, Integer> frequencyMap = segmentTree.query(l, r);
        int majorityThreshold = (r - l + 1) / 2;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > majorityThreshold) {
                return entry.getKey();
            }
        }
        return null; // No majority element
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 4, 1};
        int l = 1, r = 5;
        Integer majorityElement = majorityElementInRange(arr, l, r);
        if (majorityElement != null) {
            System.out.println("Majority element in range [" + l + ", " + r + "] is: " + majorityElement);
        } else {
            System.out.println("No majority element in range [" + l + ", " + r + "]");
        }
    }
}
