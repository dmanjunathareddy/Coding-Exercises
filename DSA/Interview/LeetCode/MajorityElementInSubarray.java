package com.softgroup.dsa.interview.leetcode.top150;
import java.util.*;

class MajorityElementInSubarray {
    static class SegmentTreeNode {
        int candidate;
        int count;
        
        SegmentTreeNode(int candidate, int count) {
            this.candidate = candidate;
            this.count = count;
        }
    }

    static class SegmentTree {
        SegmentTreeNode[] tree;
        int[] arr;
        int n;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            this.tree = new SegmentTreeNode[4 * n];
            build(0, 0, n - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = new SegmentTreeNode(arr[start], 1);
            } else {
                int mid = (start + end) / 2;
                build(2 * node + 1, start, mid);
                build(2 * node + 2, mid + 1, end);
                tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        private SegmentTreeNode merge(SegmentTreeNode left, SegmentTreeNode right) {
            if (left.candidate == right.candidate) {
                return new SegmentTreeNode(left.candidate, left.count + right.count);
            } else if (left.count > right.count) {
                return new SegmentTreeNode(left.candidate, left.count - right.count);
            } else {
                return new SegmentTreeNode(right.candidate, right.count - left.count);
            }
        }

        public SegmentTreeNode query(int L, int R) {
            return query(0, 0, n - 1, L, R);
        }

        private SegmentTreeNode query(int node, int start, int end, int L, int R) {
            if (R < start || end < L) {
                return new SegmentTreeNode(-1, 0); // return invalid node
            }
            if (L <= start && end <= R) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            SegmentTreeNode left = query(2 * node + 1, start, mid, L, R);
            SegmentTreeNode right = query(2 * node + 2, mid + 1, end, L, R);
            return merge(left, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 2, 1};
        SegmentTree segmentTree = new SegmentTree(arr);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.println("Enter the range L and R:");
            int L = sc.nextInt();
            int R = sc.nextInt();
            SegmentTreeNode result = segmentTree.query(L, R);

            // Verify if the candidate is actually the majority
            int count = 0;
            for (int j = L; j <= R; j++) {
                if (arr[j] == result.candidate) {
                    count++;
                }
            }

            if (count > (R - L + 1) / 2) {
                System.out.println("Majority element in range [" + L + ", " + R + "] is: " + result.candidate);
            } else {
                System.out.println("No majority element in range [" + L + ", " + R + "]");
            }
        }

        sc.close();
    }
}
