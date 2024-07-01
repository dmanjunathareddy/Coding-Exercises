package com.softgroup.dsa.interview.leetcode;
public class SmallestGoodBase {

    public static void main(String[] args) {
        String n = "13";
        System.out.println("Smallest good base for " + n + " is: " + smallestGoodBase(n));
    }

    public static String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            long k = (long) Math.pow(num + 1, 1.0 / m);
            long sum = 1, cur = 1;
            for (int i = 1; i <= m; i++) {
                cur *= k;
                sum += cur;
            }
            if (sum == num) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }
}
