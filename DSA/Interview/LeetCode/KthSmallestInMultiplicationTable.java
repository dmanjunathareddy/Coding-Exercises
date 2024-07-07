package com.softgroup.dsa.interview.leetcode;
public class KthSmallestInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (enough(mid, m, n, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    private boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public static void main(String[] args) {
        KthSmallestInMultiplicationTable solver = new KthSmallestInMultiplicationTable();
        System.out.println(solver.findKthNumber(3, 3, 5)); // Example test case
        System.out.println(solver.findKthNumber(2, 3, 6));
    }
}
