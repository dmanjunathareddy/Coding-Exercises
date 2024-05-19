package com.softgroup.dsa.interview;
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1) return 1;

        int first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " steps: " + climbStairs(n)); // Output should be 8
    }
}
