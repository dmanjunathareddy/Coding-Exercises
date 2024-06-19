package com.softgroup.dsa.interview.leetcode;
public class NumberOfDigitOne {
    public static void main(String[] args) {
        int n = 13;  // Example input
        System.out.println(countDigitOne(n));  // Output: 6
    }

    public static int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long divider = k * 10;
            count += (n / divider) * k + Math.min(Math.max(n % divider - k + 1, 0), k);
        }
        return count;
    }
}
