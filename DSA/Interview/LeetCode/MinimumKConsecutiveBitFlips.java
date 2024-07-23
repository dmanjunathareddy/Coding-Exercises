package com.softgroup.dsa.interview.leetcode;
class MinimumKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int flipCount = 0, result = 0;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >= K) {
                flipCount ^= isFlipped[i - K];
            }

            if (A[i] == flipCount) {
                if (i + K > n) {
                    return -1;
                }
                result++;
                flipCount ^= 1;
                isFlipped[i] = 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumKConsecutiveBitFlips solution = new MinimumKConsecutiveBitFlips();
        int[] A = {0, 1, 0};
        int K = 1;
        System.out.println(solution.minKBitFlips(A, K)); // Output: 2

        int[] B = {1, 1, 0};
        System.out.println(solution.minKBitFlips(B, K)); // Output: -1

        int[] C = {0, 0, 0, 1, 0, 1, 1, 0};
        K = 3;
        System.out.println(solution.minKBitFlips(C, K)); // Output: 3
    }
}
