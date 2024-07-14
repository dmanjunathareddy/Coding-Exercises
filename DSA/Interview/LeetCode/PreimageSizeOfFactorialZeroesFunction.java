package com.softgroup.dsa.interview.leetcode;
public class PreimageSizeOfFactorialZeroesFunction {

    public int preimageSizeFZF(int K) {
        return (int) (findRight(K) - findLeft(K) + 1);
    }

    private long findLeft(int K) {
        long low = 0, high = 5L * (K + 1);
        while (low < high) {
            long mid = (low + high) / 2;
            if (zeta(mid) < K) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long findRight(int K) {
        long low = 0, high = 5L * (K + 1);
        while (low < high) {
            long mid = (low + high) / 2;
            if (zeta(mid) <= K) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }

    private long zeta(long x) {
        long res = 0;
        while (x > 0) {
            x /= 5;
            res += x;
        }
        return res;
    }

    public static void main(String[] args) {
        PreimageSizeOfFactorialZeroesFunction solver = new PreimageSizeOfFactorialZeroesFunction();
        System.out.println(solver.preimageSizeFZF(0)); // Output: 5
        System.out.println(solver.preimageSizeFZF(5)); // Output: 0
        System.out.println(solver.preimageSizeFZF(3)); // Output: 5
    }
}
