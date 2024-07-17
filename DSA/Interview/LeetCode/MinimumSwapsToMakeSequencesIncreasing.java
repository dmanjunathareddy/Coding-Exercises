package com.softgroup.dsa.interview.leetcode;
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] keep = new int[n];
        int[] swap = new int[n];
        java.util.Arrays.fill(keep, Integer.MAX_VALUE);
        java.util.Arrays.fill(swap, Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;
        
        for (int i = 1; i < n; ++i) {
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                keep[i] = keep[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                keep[i] = Math.min(keep[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
            }
        }
        return Math.min(keep[n - 1], swap[n - 1]);
    }

    public static void main(String[] args) {
        MinimumSwapsToMakeSequencesIncreasing ms = new MinimumSwapsToMakeSequencesIncreasing();
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};
        System.out.println(ms.minSwap(A, B));  // Output: 1
    }
}
