package com.softgroup.dsa.interview.leetcode;
import java.util.Arrays;

public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MakeArrayStrictlyIncreasing solution = new MakeArrayStrictlyIncreasing();
        int[] arr = {1, 5, 2, 4, 6};
        int result = solution.makeArrayIncreasing(arr);
        System.out.println("Minimum modifications needed: " + result);
    }
}
