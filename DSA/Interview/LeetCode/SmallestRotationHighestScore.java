package com.softgroup.dsa.interview.leetcode;
public class SmallestRotationHighestScore {
    public int bestRotation(int[] A) {
        int N = A.length;
        int[] change = new int[N];
        for (int i = 0; i < N; ++i)
            change[(i - A[i] + 1 + N) % N] -= 1;
        for (int i = 1; i < N; ++i)
            change[i] += change[i - 1] + 1;

        int best = 0;
        for (int i = 0; i < N; ++i)
            if (change[i] > change[best])
                best = i;
        return best;
    }

    public static void main(String[] args) {
        SmallestRotationHighestScore srhs = new SmallestRotationHighestScore();
        int[] A = {2, 3, 1, 4, 0};
        System.out.println(srhs.bestRotation(A));  // Output: 3
    }
}
